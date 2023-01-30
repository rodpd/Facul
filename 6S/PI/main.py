import os
import numpy as np
import gc
import cv2 as cv2
import tkinter as tk
import pydicom
import png
import mahotas
import random
import pandas as pd
import math
import pylab
import PIL.Image, PIL.ImageTk
from pympler import asizeof
from tkinter import *
from tkinter import ttk, filedialog
from PIL import ImageTk, Image
import time
from pydicom.pixel_data_handlers.util import apply_voi_lut
from pydicom.pixel_data_handlers.util import apply_modality_lut
from pandastable import Table, TableModel

class Recorte:
    def __init__(self, img_file, scale):
        self.refPt = []
        self.image = cv2.imread(img_file)
        self.clone = self.image.copy()
    
    def click_and_crop(self, event, x, y, flags, param):
        # if the left mouse button was clicked, record the starting
        # (x, y) coordinates and indicate that cropping is being
        # performed
        if event == cv2.EVENT_LBUTTONDOWN:
            self.image = self.clone.copy()
            if self.image.shape[1] >= 128 and self.image.shape[0] >= 128:
                if (x - 64) < 0:
                    coord1x = 0
                    coord2x = 128
                else:
                    coord1x = x - 64
                    if (x+ 64) > self.image.shape[1]:
                        coord1x = self.image.shape[1] - 128
                        coord2x = self.image.shape[1]
                    else:
                        coord2x = x + 64
                if (y - 64) < 0:
                    coord1y = 0
                    coord2y = 128
                else:
                    coord1y = y - 64
                    if (y+64) > self.image.shape[0]:
                        coord1y = self.image.shape[0] - 128
                        coord2y = self.image.shape[0]
                    else:
                        coord2y = y + 64 
            else:
               coord1x = 0
               coord2x = self.image.shape[1]
               coord1y = 0   
               coord2y = self.image.shape[0]
            
            #print(coord1x, coord1y, ":", coord2x, coord2y)
            
            self.refPt = [(coord1x, coord1y)]
            self.refPt.append((coord2x, coord2y))
            cv2.rectangle(self.image, self.refPt[0], self.refPt[1], (0, 100, 0), 2)
            cv2.imshow("Selecionar area", self.image)

    def main(self):
        cv2.namedWindow("Selecionar area" )
        cv2.setMouseCallback("Selecionar area", self.click_and_crop)
        # keep looping until the 'c' key is pressed
        while True:
            # display the image and wait for a keypress
            cv2.imshow("Selecionar area", self.image)
            key = cv2.waitKey(1) & 0xFF
        
            # if the 'r' key is pressed, reset the cropping region
            if key == ord("r"):
                self.cropping = True
                self.image = self.clone.copy()
        
            # if the 'c' key is pressed, break from the loop
            elif key == ord("c"):
                roi = self.clone[self.refPt[0][1]:self.refPt[1][1], self.refPt[0][0]:self.refPt[1][0]]
                cv2.imwrite("regiao-interesse.png", roi)
                break
            if cv2.getWindowProperty("Selecionar area", 1) == -1:
                if not self.refPt:
                    cv2.imwrite("regiao-interesse.png", self.image)
                else:
                    roi = self.clone[self.refPt[0][1]:self.refPt[1][1], self.refPt[0][0]:self.refPt[1][0]]
                    cv2.imwrite("regiao-interesse.png", roi)
                break
                
        # close all open windows
        cv2.destroyAllWindows()

class ScrollableImage(ttk.Frame):
    def __init__(self, master=None, **kw):
        self.image = kw.pop('image', None)
        sw = kw.pop('scrollbarwidth', 10)
        super(ScrollableImage, self).__init__(master=master, **kw)
        self.cnvs = tk.Canvas(self, highlightthickness=0, **kw)
        self.cnvs.create_image(0, 0, anchor='nw', image=self.image)
        # Vertical and Horizontal scrollbars
        self.v_scroll = tk.Scrollbar(self, orient='vertical')
        self.h_scroll = tk.Scrollbar(self, orient='horizontal')
        # Grid and configure weight.
        self.cnvs.grid(row=0, column=0,  sticky='nsew')
        self.h_scroll.grid(row=1, column=0, sticky='ew')
        self.v_scroll.grid(row=0, column=1, sticky='ns')
        self.rowconfigure(0, weight=1)
        self.columnconfigure(0, weight=1)
        # Set the scrollbars to the canvas
        self.cnvs.config(xscrollcommand=self.h_scroll.set, 
                           yscrollcommand=self.v_scroll.set)
        # Set canvas view to the scrollbars
        self.v_scroll.config(command=self.cnvs.yview)
        self.h_scroll.config(command=self.cnvs.xview)
        # Assign the region to be scrolled 
        self.cnvs.config(scrollregion=self.cnvs.bbox('all'))
        self.cnvs.bind_class(self.cnvs, "<MouseWheel>", self.mouse_scroll)

    def refresh(self, master=None, **kw):
        self.image = kw.pop('image', None)
        kw.pop('scrollbarwidth', 10)
        super(ScrollableImage, self).__init__(master=master, **kw)
        self.cnvs = tk.Canvas(self, highlightthickness=0, **kw)
        self.cnvs.create_image(0, 0, anchor='nw', image=self.image)
        # Vertical and Horizontal scrollbars
        self.v_scroll = tk.Scrollbar(self, orient='vertical')
        self.h_scroll = tk.Scrollbar(self, orient='horizontal')
        # Grid and configure weight.
        self.cnvs.grid(row=0, column=0,  sticky='nsew')
        self.h_scroll.grid(row=1, column=0, sticky='ew')
        self.v_scroll.grid(row=0, column=1, sticky='ns')
        self.rowconfigure(0, weight=1)
        self.columnconfigure(0, weight=1)
        # Set the scrollbars to the canvas
        self.cnvs.config(xscrollcommand=self.h_scroll.set, 
                           yscrollcommand=self.v_scroll.set)
        # Set canvas view to the scrollbars
        self.v_scroll.config(command=self.cnvs.yview)
        self.h_scroll.config(command=self.cnvs.xview)
        # Assign the region to be scrolled 
        self.cnvs.config(scrollregion=self.cnvs.bbox('all'))
        self.cnvs.bind_class(self.cnvs, "<MouseWheel>", self.mouse_scroll)

    def mouse_scroll(self, evt):
        if evt.state == 0 :
            self.cnvs.yview_scroll(-1*(evt.delta), 'units') # For MacOS
            self.cnvs.yview_scroll(int(-1*(evt.delta/120)), 'units') # For windows
        if evt.state == 1:
            self.cnvs.xview_scroll(-1*(evt.delta), 'units') # For MacOS
            self.cnvs.xview_scroll(int(-1*(evt.delta/120)), 'units') # For windows

class Programa:
    scale = NONE
    photo = NONE

    def __init__(self, width, height, title, background):
        self.width = width
        self.height = height
        self.resolution = str(width) + "x" + str(height) 
        self.root = Tk()
        self.root.title(title)
        self.root.geometry(self.resolution) # Screen resolution
        self.root.configure(background=background)
        self.dirLido = False
        self.main()
    
    def zoomButtonState(self):
        for widget in self.tb1.winfo_children():
            if widget.widgetName == 'button' and widget._name == 'zoomIn' and self.scale >= 3:
                widget.configure(state=DISABLED)
            elif widget.widgetName == 'button' and widget._name == 'zoomOut' and self.scale <= 0.25:
                widget.configure(state=DISABLED)
            elif widget.widgetName == 'button' and (widget._name == 'zoomOut' or widget._name == 'zoomIn') and self.scale >= 0.25:
                widget.configure(state=NORMAL)
                
    def zoomIn(self, event=None):
        if self.scale < 1:
            self.scale = self.scale*2
            (width, height) = ((int)(self.photoZoomOut.width * self.scale), (int)(self.photoZoomOut.height * self.scale))
            self.photo = ImageTk.PhotoImage(self.photoZoomOut.resize((width, height)))
            self.imageZoom()
            self.zoomButtonState()
        elif self.scale < 3:
            self.scale = (int)(self.scale + 1) #* 2
            self.photo = self.photoZoomIn.zoom(x=self.scale, y=self.scale)
            self.imageZoom()
            self.zoomButtonState()
        else:
            self.zoomButtonState()
        self.root.update()
        gc.collect()

    def zoomOut(self, event=None):
        if self.scale > 1:
            self.scale = self.scale-1
            self.photoZoomIn = self.photoZoomInDefault
        else:
            self.scale = self.scale/2
            self.photoZoomIn = self.photoZoomInDefault
        (width, height) = ((int)(self.photoZoomOut.width * self.scale), (int)(self.photoZoomOut.height * self.scale))
        self.photo = ImageTk.PhotoImage(self.photoZoomOut.resize((width, height)))
        self.imageZoom()
        self.zoomButtonState()
        self.root.update()
        gc.collect()

    def converterTif(self, event=None):
        image = cv2.imread(self.caminhoImg)
        cv2.imwrite('img.png',image)
        image = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
        image = PhotoImage(file="img.png")
        os.remove("./img.png")
        return(image)

    def converterDcm(self, event=None):
        #np.set_printoptions(threshold=sys.maxsize)
        ds = pydicom.dcmread(self.caminhoImg, force=True)

        if ( (not hasattr(ds, "WindowCenter")) and ds.PixelRepresentation == 1 ):
            ds.add_new(0x00281050, 'DS', "40.0")
            ds.add_new(0x00281051, 'DS', "400.0")

        shape = ds.pixel_array.shape
        img = ds.pixel_array.copy()
        img = apply_modality_lut(img, ds)
        img = apply_voi_lut(img, ds)

        #inverter img se for monochrome1
        if (ds.PhotometricInterpretation == "MONOCHROME1"):
            pot = (2**ds.BitsStored)-1
            img = pot - img

        if ( hasattr(ds, "RescaleSlope")):
            img = img * ds.RescaleSlope
        if ( hasattr(ds, "RescaleIntercept")):
            img = img + abs(ds.RescaleIntercept)

        #passar p/ 8 bits
        if ( ds.BitsAllocated != 8):
            pot = (2**ds.BitsStored)
            img = img/(pot/256)

        #converter p/ unsigned
        img = np.uint8(img)
        if ( ds.PixelRepresentation == 1 ):
            img = img + 128

        # salvar png
        with open("./img.png", 'wb') as png_file:
            w = png.Writer(shape[1], shape[0], bitdepth = 8, greyscale=True)
            w.write(png_file, img)

        image = PhotoImage(file="img.png")
        return image

    def selecionarImg(self, event=None):
        try:
            self.regIntTxt.destroy()
            self.regInt.destroy()
        except AttributeError:
            pass
        self.caminhoImg = filedialog.askopenfilename(title="Selecionar Imagem", filetypes=[("png/dcom/tiff/tif files","*.png;*.dcm;*.tiff;*.tif")])

        if ( len(self.caminhoImg) > 0):
            self.button_4.configure(state=NORMAL)
            if ( self.caminhoImg[-3:].lower() == "png"):
                self.image_window.grid_forget()
                self.photo = PhotoImage(file=self.caminhoImg)
                self.scale = 1
                self.imageZoom()
                self.photoZoomIn = tk.PhotoImage(file=self.caminhoImg)
                self.photoZoomInDefault = self.photoZoomIn
                self.photoZoomOut = Image.open(self.caminhoImg)
                self.zoomButtonState()
            elif ( self.caminhoImg[-3:].lower() == "tif" or self.caminhoImg[-4:].lower() == "tiff"):
                self.image_window.grid_forget()
                self.photo = self.converterTif()
                self.scale = 1
                self.imageZoom()
                self.photoZoomIn = self.converterTif()
                self.photoZoomInDefault = self.photoZoomIn
                self.photoZoomOut = Image.open(self.caminhoImg)
                self.caminhoImg = "teste.png"
                self.zoomButtonState()
            elif ( self.caminhoImg[-3:].lower() == "dcm"):
                self.image_window.grid_forget()
                self.photo = self.converterDcm()
                self.scale = 1
                self.imageZoom()
                self.photoZoomIn = self.photo
                self.photoZoomInDefault = self.photoZoomIn
                self.photoZoomOut = Image.open("./img.png")
                self.caminhoImg = "teste.png"
                self.zoomButtonState()

    def setImagens(self, image_number):
        self.my_label1 = Label(self.tb2, image=self.Listaimgs[0][image_number])
        self.my_label2 = Label(self.tb2, image=self.Listaimgs[1][image_number])
        self.my_label3 = Label(self.tb2, image=self.Listaimgs[2][image_number])
        self.my_label4 = Label(self.tb2, image=self.Listaimgs[3][image_number])

    def setGrid(self):
        self.my_label1.grid(row=1, column=0)
        self.my_label2.grid(row=1, column=1)
        self.my_label3.grid(row=1, column=2)
        self.my_label4.grid(row=1, column=3)
        self.button_back.grid(row=2, column=0)
        self.button_forward.grid(row=2, column=3)
        self.status.grid(row=3, column=0, columnspan=4, sticky=W+E)
        self.txtLabel.grid(row=0, column=0)
        self.txtLabel.grid(row=0, column=1)
        self.txtLabel.grid(row=0, column=2)
        self.txtLabel.grid(row=0, column=3)

    def forward(self, image_number):
        self.tb2.grid_forget()
        self.button_forward = Button(self.tb2, text=">>", command=lambda: self.forward(image_number+1))
        self.button_back = Button(self.tb2, text="<<", command=lambda: self.back(image_number-1))
        self.setImagens(image_number)
        self.status = Label(self.tb2, text="Image " + str(image_number+1) + " of 100" , bd=1, relief=SUNKEN, anchor=E)

        if len(self.Listaimgs[0]) == image_number + 1:
            self.button_forward = Button(self.tb2, text=">>", state=DISABLED)
        
        self.setGrid()

    def back(self, image_number):
        self.tb2.grid_forget()
        self.button_forward = Button(self.tb2, text=">>", command=lambda: self.forward(image_number+1))
        self.button_back = Button(self.tb2, text="<<", command=lambda: self.back(image_number-1))
        self.setImagens(image_number)
        self.status = Label(self.tb2, text="Image " + str(image_number+1) + " of 100" , bd=1, relief=SUNKEN, anchor=E)

        if image_number == 0:
            self.button_back = Button(self.tb2, text="<<", state=DISABLED)
        
        self.setGrid()

    def gridDiretorio(self):
        self.status = Label(self.tb2, text="Image 1 of 100" , bd=1, relief=SUNKEN, anchor=E)
        self.txtLabel = Label(self.tb2, text="BIRADS I")
        self.txtLabel.grid(row=0, column=0)
        self.txtLabel = Label(self.tb2, text="BIRADS II")
        self.txtLabel.grid(row=0, column=1)
        self.txtLabel = Label(self.tb2, text="BIRADS III")
        self.txtLabel.grid(row=0, column=2)
        self.txtLabel = Label(self.tb2, text="BIRADS IV")
        self.txtLabel.grid(row=0, column=3)
        self.my_label1 = Label(self.tb2, image=self.Listaimgs[0][0])
        self.my_label1.grid(row=1, column=0)
        self.my_label2 = Label(self.tb2, image=self.Listaimgs[1][0])
        self.my_label2.grid(row=1, column=1)
        self.my_label3 = Label(self.tb2, image=self.Listaimgs[2][0])
        self.my_label3.grid(row=1, column=2)
        self.my_label4 = Label(self.tb2, image=self.Listaimgs[3][0])
        self.my_label4.grid(row=1, column=3)
        self.button_back = Button(self.tb2, text="<<", command=self.back(0), state=DISABLED)
        self.button_forward = Button(self.tb2, text=">>", command=lambda: self.forward(1))
        self.button_back.grid(row=2, column=0)
        self.button_forward.grid(row=2, column=3, pady=10)
        self.status.grid(row=3, column=0, columnspan=4, sticky=W+E)

    def selecionarDir(self, event=None):
        pathDir = filedialog.askdirectory()
        pathDir = pathDir.replace( "\." ,  "/" )
        self.Listaimgs = [],[],[],[]
        self.caminhosImgs = [],[],[],[]
        for i in range(4):
            if os.path.exists(pathDir + "/" + str(i+1)):
                #print(pathDir)
                for img in os.listdir(pathDir + "/" + str(i+1)):
                    #print(img)
                    imgPath = pathDir + "/" + str(i+1) + "/" + str(img)
                    self.caminhosImgs[i].append(imgPath)
                    if img[-3:] == "png":
                        self.Listaimgs[i].append(ImageTk.PhotoImage(Image.open(imgPath)))
        
        if len(self.Listaimgs[0]) == 100 and len(self.Listaimgs[1]) == 100 and len(self.Listaimgs[2]) == 100 and len(self.Listaimgs[3]) == 100:
            self.gridDiretorio()
            self.dirLido = True
        else:
            self.dirLido = False
            self.tb2.grid_forget()
            self.button_back = Button(self.tb2, text="<<", state=DISABLED)
            self.button_forward = Button(self.tb2, text=">>", state=DISABLED)
            self.button_back.grid(row=2, column=0)
            self.button_forward.grid(row=2, column=3)
            self.status = Label(self.tb2, text="Image 0 of 100" , bd=1, relief=SUNKEN, anchor=E)
            self.status.grid(row=3, column=0, columnspan=4, sticky=W+E)
    
    def setAbaTreino(self,event=None):
        def checarCarc(self):
            if (self.homogeneidade.get() or self.entropia.get() or self.energia.get() or self.contraste.get()) and self.dirLido:
                button = Button(self.tb3, text="Treinar Classificador", command=lambda: self.treinar(), width=20, fg="blue", bg="grey", name='treino', state=NORMAL)
                button.grid(row=4,column=2, sticky=W)
            else:
                button = Button(self.tb3, text="Treinar Classificador", command=lambda: self.treinar(), width=20, fg="blue", bg="grey", name='treino', state=DISABLED)
                button.grid(row=4,column=2, sticky=W)

        txtLabel = Label(self.tb3, text="       ")
        txtLabel.grid(row=0, column=0)

        txtLabel = Label(self.tb3, text="Escolher características: ")
        txtLabel.grid(row=1, column=0)
        self.homogeneidade = tk.BooleanVar()
        self.entropia = tk.BooleanVar()
        self.energia = tk.BooleanVar()
        self.contraste = tk.BooleanVar()
        
        c1 = tk.Checkbutton(self.tb3, text='Homogenidade',variable=self.homogeneidade, onvalue=True, offvalue=False, width=15, command=lambda: checarCarc(self))
        c1.grid(row=2, column=0, sticky=W)
        c1 = tk.Checkbutton(self.tb3, text='Entropia',variable=self.entropia, onvalue=True, offvalue=False, width=15, command=lambda: checarCarc(self))
        c1.grid(row=2, column=1, sticky=W)
        c1 = tk.Checkbutton(self.tb3, text='Energia',variable=self.energia, onvalue=True, offvalue=False, width=15, command=lambda: checarCarc(self))
        c1.grid(row=2, column=2, sticky=W)
        c1 = tk.Checkbutton(self.tb3, text='Constraste',variable=self.contraste, onvalue=True, offvalue=False, width=15, command=lambda: checarCarc(self))
        c1.grid(row=2, column=3, sticky=W)
        
        txtLabel = Label(self.tb3, text="       ")
        txtLabel.grid(row=3, column=0)

        button = Button(self.tb3, text="Treinar Classificador", command=lambda: self.treinar(), width=20, fg="blue", bg="grey", name='treino', state=DISABLED)
        button.grid(row=4,column=2, sticky=W)

        txtLabel = Label(self.tb3, text="       ")
        txtLabel.grid(row=5, column=0)

    def setGridTreino(self, event=None):
        d = 5
        txtLabel = Label(self.tb3, text="Resultados Treino ")
        txtLabel.grid(row=1+d, column=0)
        texto = "Acuracia: " + str(self.acuracia)
        txtLabel = Label(self.tb3, text=texto)
        txtLabel.grid(row=1+d, column=2)
        texto = "Especificidade: " + str(round(self.especificidade, 3))
        txtLabel = Label(self.tb3, text=texto)
        txtLabel.grid(row=2+d, column=2)

        texto = "Tempo Trenio: " + str(self.tempoTreino) + " seg"
        txtLabel = Label(self.tb3, text=texto)
        txtLabel.grid(row=1+d, column=1)
        texto = "Tempo Classificação: " + str(self.tempoClass) + " seg"
        txtLabel = Label(self.tb3, text=texto)
        txtLabel.grid(row=2+d, column=1)
        
        txtLabel = Label(self.tb3, text="Matriz confusão: ")
        txtLabel.grid(row=1+d, column=3)
        for i in range(4):
            txtLabel = Label(self.tb3, text=str(i+1))
            txtLabel.grid(row=1+d, column=i+5)

        for i in range(4):
            txtLabel = Label(self.tb3, text=str(i+1))
            txtLabel.grid(row=i+2+d, column=4)
            for j in range(4):
                txtLabel = Label(self.tb3, text=self.matrizConfusao[i][j])
                txtLabel.grid(row=i+2+d, column=j+5)

    def treinar(self, event=None):
        tempoTreinoInicio = time.time()
        self.qntTreino = 75
        self.qntClassificar = 25
        qntImgs = self.qntTreino + self.qntClassificar
        self.imgsClassificar = list(range(0,qntImgs)),list(range(0,qntImgs)),list(range(0,qntImgs)),list(range(0,qntImgs))
        self.imgsTreino = [],[],[],[]
        for i in range(4):
            for j in range(self.qntTreino):
                rand = random.randint(0,self.qntClassificar+self.qntTreino-1-j)
                self.imgsTreino[i].append(self.imgsClassificar[i].pop(rand))
        
        print(self.imgsClassificar)
        print(self.imgsTreino)
        self.descritores = {"hu0": [], "hu1": [], "hu2": [], "hu3": [], "hu4": [], "hu5": [], "hu6": []}
        if self.homogeneidade.get():
            self.descritores["homogeneidade1"] = []
            self.descritores["homogeneidade2"] = []
            self.descritores["homogeneidade4"] = []
            self.descritores["homogeneidade8"] = []
            self.descritores["homogeneidade16"] = []
        if self.entropia.get():
            self.descritores["entropia1"] = []
            self.descritores["entropia2"] = []
            self.descritores["entropia4"] = []
            self.descritores["entropia8"] = []
            self.descritores["entropia16"] = []
        if self.energia.get():
            self.descritores["energia1"] = []
            self.descritores["energia2"] = []
            self.descritores["energia4"] = []
            self.descritores["energia8"] = []
            self.descritores["energia16"] = []
        if self.contraste.get():
            self.descritores["contraste1"] = []
            self.descritores["contraste2"] = []
            self.descritores["contraste4"] = []
            self.descritores["contraste8"] = []
            self.descritores["contraste16"] = []
        # homogeneidade = 4
        # entropia = 8
        # energia = 0
        # contraste = 1
        for numPasta in range(4):
            for i in range(5):
                for j in range(self.qntTreino):
                    distancia = 2**i
                    imgMahotas = mahotas.imread(self.caminhosImgs[numPasta][self.imgsTreino[numPasta][j]])
                    # reamostrar
                    tonsCinza = 32
                    img = np.round(imgMahotas/(256/tonsCinza), decimals=0)*256/tonsCinza
                    imgMahotas = np.uint8(img)

                    features = mahotas.features.haralick(imgMahotas, distance=distancia, return_mean=True)*4
                    if self.homogeneidade.get():
                        self.descritores["homogeneidade" + str(distancia)].append(features[4])
                    if self.entropia.get():
                        self.descritores["entropia" + str(distancia)].append(features[8])
                    if self.energia.get():
                        self.descritores["energia" + str(distancia)].append(features[0])
                    if self.contraste.get():
                        self.descritores["contraste" + str(distancia)].append(features[1])

            for i in range(self.qntTreino):
                im = cv2.imread(self.caminhosImgs[numPasta][self.imgsTreino[numPasta][i]], cv2.IMREAD_GRAYSCALE)
                moments = cv2.moments(im)
                huMoments = cv2.HuMoments(moments)

                self.descritores["hu0"].append(huMoments[0][0])
                self.descritores["hu1"].append(huMoments[1][0])
                self.descritores["hu2"].append(huMoments[2][0])
                self.descritores["hu3"].append(huMoments[3][0])
                self.descritores["hu4"].append(huMoments[4][0])
                self.descritores["hu5"].append(huMoments[5][0])
                self.descritores["hu6"].append(huMoments[6][0])
        
        tempoTreinoFim= time.time()
        tempoClassInicio = time.time()
        # classificar
        self.descritoresClassificados = {"hu0": [], "hu1": [], "hu2": [], "hu3": [], "hu4": [], "hu5": [], "hu6": []}
        if self.homogeneidade.get():
            self.descritoresClassificados["homogeneidade1"] = []
            self.descritoresClassificados["homogeneidade2"] = []
            self.descritoresClassificados["homogeneidade4"] = []
            self.descritoresClassificados["homogeneidade8"] = []
            self.descritoresClassificados["homogeneidade16"] = []
        if self.entropia.get():
            self.descritoresClassificados["entropia1"] = []
            self.descritoresClassificados["entropia2"] = []
            self.descritoresClassificados["entropia4"] = []
            self.descritoresClassificados["entropia8"] = []
            self.descritoresClassificados["entropia16"] = []
        if self.energia.get():
            self.descritoresClassificados["energia1"] = []
            self.descritoresClassificados["energia2"] = []
            self.descritoresClassificados["energia4"] = []
            self.descritoresClassificados["energia8"] = []
            self.descritoresClassificados["energia16"] = []
        if self.contraste.get():
            self.descritoresClassificados["contraste1"] = []
            self.descritoresClassificados["contraste2"] = []
            self.descritoresClassificados["contraste4"] = []
            self.descritoresClassificados["contraste8"] = []
            self.descritoresClassificados["contraste16"] = []
        for numPasta in range(4):
            for i in range(5):
                for j in range(self.qntClassificar):
                    distancia = 2**i
                    imgMahotas = mahotas.imread(self.caminhosImgs[numPasta][self.imgsClassificar[numPasta][j]])
                    # reamostrar
                    tonsCinza = 32
                    img = np.round(imgMahotas/(256/tonsCinza), decimals=0)*256/tonsCinza
                    imgMahotas = np.uint8(img)
                    
                    features = mahotas.features.haralick(imgMahotas, distance=distancia, return_mean=True)*4
                    if self.homogeneidade.get():
                        self.descritoresClassificados["homogeneidade" + str(distancia)].append(features[4])
                    if self.entropia.get():
                        self.descritoresClassificados["entropia" + str(distancia)].append(features[8])
                    if self.energia.get():
                        self.descritoresClassificados["energia" + str(distancia)].append(features[0])
                    if self.contraste.get():
                        self.descritoresClassificados["contraste" + str(distancia)].append(features[1])

            for i in range(self.qntClassificar):
                im = cv2.imread(self.caminhosImgs[numPasta][self.imgsTreino[numPasta][i]], cv2.IMREAD_GRAYSCALE)
                moments = cv2.moments(im)
                huMoments = cv2.HuMoments(moments)

                self.descritoresClassificados["hu0"].append(huMoments[0][0])
                self.descritoresClassificados["hu1"].append(huMoments[1][0])
                self.descritoresClassificados["hu2"].append(huMoments[2][0])
                self.descritoresClassificados["hu3"].append(huMoments[3][0])
                self.descritoresClassificados["hu4"].append(huMoments[4][0])
                self.descritoresClassificados["hu5"].append(huMoments[5][0])
                self.descritoresClassificados["hu6"].append(huMoments[6][0])

        def mahalanobis(x=None, data=None, cov=None):
            x_media = (x - np.mean(data)).to_numpy()
            if not cov:
                cov = np.cov(data.values.T)
            inversaCovariancia = np.linalg.inv(cov)
            resultado = np.empty(self.qntClassificar*4)
            for i in range(self.qntClassificar*4):
                m1 = np.dot(x_media[i], inversaCovariancia)
                resultado[i] = np.dot(m1, np.transpose(x_media[i]) )
            return resultado
        
        colunas = ["hu0", "hu1","hu2","hu3","hu4","hu5","hu6"]
        if self.homogeneidade.get():
            colunas.append("homogeneidade1")
            colunas.append("homogeneidade2")
            colunas.append("homogeneidade4")
            colunas.append("homogeneidade8")
            colunas.append("homogeneidade16")
        if self.entropia.get():
            colunas.append("entropia1")
            colunas.append("entropia2")
            colunas.append("entropia4")
            colunas.append("entropia8")
            colunas.append("entropia16")
        if self.energia.get():
            colunas.append("energia1")
            colunas.append("energia2")
            colunas.append("energia4")
            colunas.append("energia8")
            colunas.append("energia16")
        if self.contraste.get():
            colunas.append("contraste1")
            colunas.append("contraste2")
            colunas.append("contraste4")
            colunas.append("contraste8")
            colunas.append("contraste16")
        dadosTreino = pd.DataFrame(self.descritores, columns=colunas)
        dadosClassificar = pd.DataFrame(self.descritoresClassificados, columns=colunas)
        distancia1 = mahalanobis(x=dadosClassificar, data=dadosTreino[0:self.qntTreino][colunas])
        distancia2 = mahalanobis(x=dadosClassificar, data=dadosTreino[self.qntTreino:self.qntTreino*2][colunas])
        distancia3 = mahalanobis(x=dadosClassificar, data=dadosTreino[self.qntTreino*2:self.qntTreino*3][colunas])
        distancia4 = mahalanobis(x=dadosClassificar, data=dadosTreino[self.qntTreino*3:self.qntTreino*4][colunas])
        dadosClassificar["distancia1"] = distancia1
        dadosClassificar["distancia2"] = distancia2
        dadosClassificar["distancia3"] = distancia3
        dadosClassificar["distancia4"] = distancia4
        tempoClassFim = time.time()
        pd.set_option('display.max_rows', None)
        self.matrizConfusao = [[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
        for i in range(4):
            for j in range(self.qntClassificar):
                #print(self.qntClassificar*i+j)
                classe = np.argmin(list((dadosClassificar["distancia1"][self.qntClassificar*i+j], dadosClassificar["distancia2"][self.qntClassificar*i+j],
                dadosClassificar["distancia3"][self.qntClassificar*i+j], dadosClassificar["distancia4"][self.qntClassificar*i+j])))
                self.matrizConfusao[i][classe] += 1
        print(dadosClassificar)
        print(self.matrizConfusao)

        self.acuracia = 0
        for i in range(4):
            self.acuracia += self.matrizConfusao[i][i]
        self.especificidade = 1-((100-self.acuracia)/300)
        self.acuracia = self.acuracia/100
        print(self.acuracia)

        print("Treino finalizado")
        self.tempoTreino = round(tempoTreinoFim - tempoTreinoInicio, 2)
        self.tempoClass = round(tempoClassFim - tempoClassInicio, 2)
        self.setGridTreino()

    def classificarImagem(self, event=None):
        self.descritoresImagem = {"hu0": [0], "hu1": [0], "hu2": [0], "hu3": [0], "hu4": [0], "hu5": [0], "hu6": [0]}
        if self.homogeneidade.get():
            self.descritoresImagem["homogeneidade1"] = [0]
            self.descritoresImagem["homogeneidade2"] = [0]
            self.descritoresImagem["homogeneidade4"] = [0]
            self.descritoresImagem["homogeneidade8"] = [0]
            self.descritoresImagem["homogeneidade16"] = [0]
        if self.entropia.get():
            self.descritoresImagem["entropia1"] = [0]
            self.descritoresImagem["entropia2"] = [0]
            self.descritoresImagem["entropia4"] = [0]
            self.descritoresImagem["entropia8"] = [0]
            self.descritoresImagem["entropia16"] = [0]
        if self.energia.get():
            self.descritoresImagem["energia1"] = [0]
            self.descritoresImagem["energia2"] = [0]
            self.descritoresImagem["energia4"] = [0]
            self.descritoresImagem["energia8"] = [0]
            self.descritoresImagem["energia16"] = [0]
        if self.contraste.get():
            self.descritoresImagem["contraste1"] = [0]
            self.descritoresImagem["contraste2"] = [0]
            self.descritoresImagem["contraste4"] = [0]
            self.descritoresImagem["contraste8"] = [0]
            self.descritoresImagem["contraste16"] = [0]
        tmpClassificarImgInicio = time.time()
        for i in range(5):
            distancia = 2**i
            imgMahotas = mahotas.imread(self.caminhoImg)
            #if imgMahotas.ndim > 2:
            #    imgMahotas = mahotas.colors.rgb2gray(imgMahotas)
            # reamostrar
            tonsCinza = 32
            img = np.round(imgMahotas/(256/tonsCinza), decimals=0)*256/tonsCinza
            imgMahotas = np.uint8(img)
            features = mahotas.features.haralick(imgMahotas, distance=distancia, return_mean=True)*4
            if self.homogeneidade.get():
                self.descritoresImagem["homogeneidade" + str(distancia)][0] = features[4]
            if self.entropia.get():
                self.descritoresImagem["entropia" + str(distancia)][0] = features[8]
            if self.energia.get():
                self.descritoresImagem["energia" + str(distancia)][0] = features[0]
            if self.contraste.get():
                self.descritoresImagem["contraste" + str(distancia)][0] = features[1]

        im = cv2.imread(self.caminhoImg, cv2.IMREAD_GRAYSCALE)
        moments = cv2.moments(im)
        huMoments = cv2.HuMoments(moments)
        self.descritoresImagem["hu0"][0] = huMoments[0][0]
        self.descritoresImagem["hu1"][0] = huMoments[1][0]
        self.descritoresImagem["hu2"][0] = huMoments[2][0]
        self.descritoresImagem["hu3"][0] = huMoments[3][0]
        self.descritoresImagem["hu4"][0] = huMoments[4][0]
        self.descritoresImagem["hu5"][0] = huMoments[5][0]
        self.descritoresImagem["hu6"][0] = huMoments[6][0]

        def mahalanobis(x=None, data=None, cov=None):
            x_media = (x - np.mean(data)).to_numpy()
            if not cov:
                cov = np.cov(data.values.T)
            inversaCovariancia = np.linalg.inv(cov)
            resultado = np.empty(1)
            m1 = np.dot(x_media, inversaCovariancia)
            resultado = np.dot(m1, np.transpose(x_media))
            return resultado

        colunas = ["hu0", "hu1","hu2","hu3","hu4","hu5","hu6"]
        if self.homogeneidade.get():
            colunas.append("homogeneidade1")
            colunas.append("homogeneidade2")
            colunas.append("homogeneidade4")
            colunas.append("homogeneidade8")
            colunas.append("homogeneidade16")
        if self.entropia.get():
            colunas.append("entropia1")
            colunas.append("entropia2")
            colunas.append("entropia4")
            colunas.append("entropia8")
            colunas.append("entropia16")
        if self.energia.get():
            colunas.append("energia1")
            colunas.append("energia2")
            colunas.append("energia4")
            colunas.append("energia8")
            colunas.append("energia16")
        if self.contraste.get():
            colunas.append("contraste1")
            colunas.append("contraste2")
            colunas.append("contraste4")
            colunas.append("contraste8")
            colunas.append("contraste16")
        dadosTreino = pd.DataFrame(self.descritores, columns=colunas)
        dadosImagem = pd.DataFrame(self.descritoresImagem, columns=colunas)
        distancia1 = mahalanobis(x=dadosImagem, data=dadosTreino[0:self.qntTreino][colunas])
        distancia2 = mahalanobis(x=dadosImagem, data=dadosTreino[self.qntTreino:self.qntTreino*2][colunas])
        distancia3 = mahalanobis(x=dadosImagem, data=dadosTreino[self.qntTreino*2:self.qntTreino*3][colunas])
        distancia4 = mahalanobis(x=dadosImagem, data=dadosTreino[self.qntTreino*3:self.qntTreino*4][colunas])
        dadosImagem["distancia1"] = distancia1
        dadosImagem["distancia2"] = distancia2
        dadosImagem["distancia3"] = distancia3
        dadosImagem["distancia4"] = distancia4
        tmpClassificarImgFim = time.time()
        tmpClassificarImgRes = round(tmpClassificarImgFim - tmpClassificarImgInicio, 2)

        classe = np.argmin(list((dadosImagem["distancia1"][0], dadosImagem["distancia2"][0],dadosImagem["distancia3"][0], dadosImagem["distancia4"][0])))+1
        print(dadosImagem)
        print(str(classe))

        #Pop up for pandas table with image caracteristics
        newWindow = Toplevel(self.root)
        classe_birds = "Classe BIRDS = " + str(classe)
        newWindow.title("Resultado da classificação da imagem: " + classe_birds + " // Tempo gasto: " + str(tmpClassificarImgRes) + " seg")
        newWindow.geometry("640x480")
        
        self.table = pt = Table(newWindow, dataframe=dadosImagem,showtoolbar=True, showstatusbar=True)
        pt.show()

    def classificarRegiao(self, event=None):
        self.descritoresImagem = {"hu0": [0], "hu1": [0], "hu2": [0], "hu3": [0], "hu4": [0], "hu5": [0], "hu6": [0]}
        if self.homogeneidade.get():
            self.descritoresImagem["homogeneidade1"] = [0]
            self.descritoresImagem["homogeneidade2"] = [0]
            self.descritoresImagem["homogeneidade4"] = [0]
            self.descritoresImagem["homogeneidade8"] = [0]
            self.descritoresImagem["homogeneidade16"] = [0]
        if self.entropia.get():
            self.descritoresImagem["entropia1"] = [0]
            self.descritoresImagem["entropia2"] = [0]
            self.descritoresImagem["entropia4"] = [0]
            self.descritoresImagem["entropia8"] = [0]
            self.descritoresImagem["entropia16"] = [0]
        if self.energia.get():
            self.descritoresImagem["energia1"] = [0]
            self.descritoresImagem["energia2"] = [0]
            self.descritoresImagem["energia4"] = [0]
            self.descritoresImagem["energia8"] = [0]
            self.descritoresImagem["energia16"] = [0]
        if self.contraste.get():
            self.descritoresImagem["contraste1"] = [0]
            self.descritoresImagem["contraste2"] = [0]
            self.descritoresImagem["contraste4"] = [0]
            self.descritoresImagem["contraste8"] = [0]
            self.descritoresImagem["contraste16"] = [0]
        tmpClassificarRegiaoInicio = time.time()
        for i in range(5):
            distancia = 2**i
            imgMahotas = mahotas.imread("regiao-interesse.png")
            imgMahotas = mahotas.colors.rgb2gray(imgMahotas)
            # reamostrar
            tonsCinza = 32
            img = np.round(imgMahotas/(256/tonsCinza), decimals=0)*256/tonsCinza
            imgMahotas = np.uint8(img)
            
            features = mahotas.features.haralick(imgMahotas, distance=distancia, return_mean=True)*4
            if self.homogeneidade.get():
                self.descritoresImagem["homogeneidade" + str(distancia)][0] = features[4]
            if self.entropia.get():
                self.descritoresImagem["entropia" + str(distancia)][0] = features[8]
            if self.energia.get():
                self.descritoresImagem["energia" + str(distancia)][0] = features[0]
            if self.contraste.get():
                self.descritoresImagem["contraste" + str(distancia)][0] = features[1]

        im = cv2.imread(self.caminhoImg, cv2.IMREAD_GRAYSCALE)
        moments = cv2.moments(im)
        huMoments = cv2.HuMoments(moments)

        self.descritoresImagem["hu0"][0] = huMoments[0][0]
        self.descritoresImagem["hu1"][0] = huMoments[1][0]
        self.descritoresImagem["hu2"][0] = huMoments[2][0]
        self.descritoresImagem["hu3"][0] = huMoments[3][0]
        self.descritoresImagem["hu4"][0] = huMoments[4][0]
        self.descritoresImagem["hu5"][0] = huMoments[5][0]
        self.descritoresImagem["hu6"][0] = huMoments[6][0]

        def mahalanobis(x=None, data=None, cov=None):
            x_media = (x - np.mean(data)).to_numpy()
            if not cov:
                cov = np.cov(data.values.T)
            inversaCovariancia = np.linalg.inv(cov)
            resultado = np.empty(1)
            m1 = np.dot(x_media, inversaCovariancia)
            resultado = np.dot(m1, np.transpose(x_media))
            return resultado

        colunas = ["hu0", "hu1","hu2","hu3","hu4","hu5","hu6"]
        if self.homogeneidade.get():
            colunas.append("homogeneidade1")
            colunas.append("homogeneidade2")
            colunas.append("homogeneidade4")
            colunas.append("homogeneidade8")
            colunas.append("homogeneidade16")
        if self.entropia.get():
            colunas.append("entropia1")
            colunas.append("entropia2")
            colunas.append("entropia4")
            colunas.append("entropia8")
            colunas.append("entropia16")
        if self.energia.get():
            colunas.append("energia1")
            colunas.append("energia2")
            colunas.append("energia4")
            colunas.append("energia8")
            colunas.append("energia16")
        if self.contraste.get():
            colunas.append("contraste1")
            colunas.append("contraste2")
            colunas.append("contraste4")
            colunas.append("contraste8")
            colunas.append("contraste16")
        dadosTreino = pd.DataFrame(self.descritores, columns=colunas)
        dadosImagem = pd.DataFrame(self.descritoresImagem, columns=colunas)
        distancia1 = mahalanobis(x=dadosImagem, data=dadosTreino[0:self.qntTreino][colunas])
        distancia2 = mahalanobis(x=dadosImagem, data=dadosTreino[self.qntTreino:self.qntTreino*2][colunas])
        distancia3 = mahalanobis(x=dadosImagem, data=dadosTreino[self.qntTreino*2:self.qntTreino*3][colunas])
        distancia4 = mahalanobis(x=dadosImagem, data=dadosTreino[self.qntTreino*3:self.qntTreino*4][colunas])
        dadosImagem["distancia1"] = distancia1
        dadosImagem["distancia2"] = distancia2
        dadosImagem["distancia3"] = distancia3
        dadosImagem["distancia4"] = distancia4
        tmpClassificarRegiaoFim = time.time()
        tmpClassificarRegiaoRes = round(tmpClassificarRegiaoFim - tmpClassificarRegiaoInicio, 2)
        
        classe = np.argmin(list((dadosImagem["distancia1"][0], dadosImagem["distancia2"][0],dadosImagem["distancia3"][0], dadosImagem["distancia4"][0])))+1
        print(dadosImagem)
        print(classe)

        #Pop up for pandas table with image caracteristics
        newWindow = Toplevel(self.root)
        classe_birds = "Classe BIRDS = " + str(classe)
        newWindow.title("Resultado da classificação da regiao: " + classe_birds + " // Tempo gasto: " + str(tmpClassificarRegiaoRes) + " seg")
        newWindow.geometry("640x480")
        
        self.table = pt = Table(newWindow, dataframe=dadosImagem,showtoolbar=True, showstatusbar=True)
        pt.show()
  
    def select(self, event=None):
        if self.scale <= 1:
            (width, height) = ((int)(self.photoZoomOut.width * self.scale), (int)(self.photoZoomOut.height * self.scale))
            self.im_resized = self.photoZoomOut.resize((width, height))            
            self.im_resized.save('image-zoom.png', quality=95)
        else: 
            self.photof = self.photoZoomIn.zoom(x=self.scale, y=self.scale)
            self.photof.write("image-zoom.png", format="png")
        
        metodo = Recorte("image-zoom.png", self.scale)
        metodo.main()

        imgR = PhotoImage(file="regiao-interesse.png")
        if imgR.width() == 128 and imgR.height() == 128:
            self.regInt = Label(self.tb1, image=imgR)
            self.regInt.image = imgR
            self.regIntTxt = Label(self.tb1, text="Regiao de interesse selecionada:")
            self.regIntTxt.grid(row=2, column = 0)
            self.regInt.grid(row=2, column = 1)

            imgMahotas = mahotas.imread("regiao-interesse.png")
            imgMahotas = mahotas.colors.rgb2gray(imgMahotas)
            tonsCinza = 32
            img = np.round(imgMahotas/(256/tonsCinza), decimals=0)*256/tonsCinza
        else:
            self.regIntTxt.destroy()
            self.regInt.destroy()
            
    def optionsMenu(self):
        barraDeMenus = Menu(self.root)
        menuOpcoes = Menu(barraDeMenus,tearoff=0) # um menu dentro da barra de menus do app
        menuOpcoes.add_command(label="Ler Diretorio", command=self.selecionarDir)
        menuOpcoes.add_command(label="Classificar Imagem", command=self.classificarImagem)
        menuOpcoes.add_command(label="Classificar Regiao", command=self.classificarRegiao)
        menuOpcoes.add_separator()
        menuOpcoes.add_command(label="Fechar", command=self.root.quit)
        barraDeMenus.add_cascade(label="Opcoes",menu=menuOpcoes)
        self.root.config(menu=barraDeMenus)

    def notebook(self):
        nb = ttk.Notebook(self.root) # Notebook gerencia os frames, o pai é o app
        nb.place(x=0,y=0,height=self.height,width=self.width) # Screen resolution
        self.tb1 = Frame(nb)
        self.tb2 = Frame(nb)
        self.tb3 = Frame(nb)
        nb.add(self.tb1,text="Imagem")
        nb.add(self.tb2,text="Pastas")
        nb.add(self.tb3,text="Treino")
        self.setAbaTreino()
        
    def buttons(self):
        button_1 = Button(self.tb1, text="Carregar Imagem", command=lambda: self.selecionarImg(), width=20, fg="blue", bg="grey", name='load')
        button_1.grid(row=0,column=0, sticky=W)
        button_2 = Button(self.tb1, text="Zoom +", command=lambda: self.zoomIn(), width=20, fg="blue", bg="grey", name='zoomIn', state=DISABLED)
        button_2.grid(row=0,column=1)
        button_3 = Button(self.tb1, text="Zoom -", command=lambda: self.zoomOut(), width=20, fg="blue", bg="grey", name='zoomOut', state=DISABLED)
        button_3.grid(row=0,column=2)
        self.button_4 = Button(self.tb1, text="Selecionar regiao", command=lambda: self.select(), width=20, fg="blue", bg="grey",  name='saveCut', state=DISABLED)
        self.button_4.grid(row=0,column=3, sticky=E)

    def imagem(self):
        photoZoomIn = PhotoImage(file= "teste.png")
        photoZoomOut = Image.open("teste.png")
        photoZoomInDefault = photoZoomIn
        self.image_window = ScrollableImage(self.tb1, image=photoZoomIn, scrollbarwidth=10, width=960, height=520)
        self.image_window.grid(row=1, column=0, columnspan=4)

    def imageZoom(self):
        self.image_window.refresh(self.tb1,image=self.photo, scrollbarwidth=6, width=960, height=520)
        self.image_window.grid(row=1, column=0, columnspan=4)

    def main(self):
        self.optionsMenu()
        self.notebook()
        self.buttons()
        self.imagem()
        self.root.mainloop()

if __name__ == "__main__": 
    programa = Programa(1280,720,"Trabalho PI","#dde")
