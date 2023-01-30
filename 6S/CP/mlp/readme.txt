compilar com o comando gcc back.cpp -lstdc++ -lm -o back -fopenmp
executar com ./back

Resumo: Nao obtive spdup

Versão extendida:
O tempo de execucao paralelo nos comentarios é o de apenas uma função palalelizada(Treinar_Neuronios), já que como 
não foi obtido spdup aumentar a quantidade de funções paralelizadas iria apenas aumentar o tempo de execução, e essa 
função foi a que obteve o melhor tempo.

Como para realizar as operações de uma camada é preciso terminar receber os dados da camada anterior, não devería ser 
possível paralelizara classe de rede. Assim, tentei paralelizar inicialmente a classe de camada, já que assim cada 
thread ficaria responsável pelas operações de um dos neurônios. Paralelizei as funções que o gprof acusou passarem 
mais tempo executando, e depois as demais funções, mas todas as tentativas fizeram com que o tempo de execução piorasse. 
Nem mesmo alterando a quantidade de camadas ou neurônios consegui algum resultado positivo. Depois disso, como última 
medida, tentei paralelizar as funções dos neurônios, já que apesar de não ser a parte paralelizável mais externa ainda 
poderia apresentar um resultado positivo, mas o tempo de execução foi ainda pior.


A inicializacao dos neuronios foi a unica funcao que apresentava algum spdup, mas não creio que possa ser utilizada 
como métrica, já que o spdup ocorria provavelmente porque a ordem de termino das threads pode variar em cada execução, 
o que pode afetar as entradas dos neuronios, facilitando o treino por pura coincidência, tanto que apesar de em algumas 
execuções o tempo ter sido melhor, em outras ele acabou piorando.
