const LANCAMENTOS = 3;
const DESTAQUES = 2;
const FUTUROS = 1;

function carregarPagina() {
    
    carregarDestaques();
    carregarLancamentos();
    carregarFuturos();
    
}


function carregarLancamentos() {
    fetch('https://api.themoviedb.org/3/movie/now_playing?api_key=6e182b534c71d1d19a36bbc7b99e113d&language=en-US&page=1')
    .then(response => {
        return response.json();
      })
      .then(data => {
      console.log(data.results);
      carregarItensLancamento(0);
      localStorage.setItem('indice_lancamentos', LANCAMENTOS);
      });
}

function carregarMaisLancamentos() {
    let indice_lancamentos = localStorage.getItem('indice_lancamentos');
    console.log(indice_lancamentos);
    carregarItensLancamento(indice_lancamentos);
    localStorage.setItem('indice_lancamentos', parseInt(indice_lancamentos)+LANCAMENTOS);
}


function carregarItensLancamento(indice_lancamentos) {
    fetch('https://api.themoviedb.org/3/movie/now_playing?api_key=6e182b534c71d1d19a36bbc7b99e113d&language=en-US&page=1')
    .then(response => {
        return response.json();
      })
      .then(data => {
      let lancamentosStr = '<div class="row">'
      for ( let i = 0; i < LANCAMENTOS; i++ ) {
        lancamentosStr += 
        `
            <div class="col-lg-4 col-md-12 col-sm-12 col-sm-12">
                <a href="detalhes.html?id=${data.results[parseInt(indice_lancamentos)+i].id}">
                    <div class="card">
                        <img class="card-img-top" src="${"https://image.tmdb.org/t/p/original" + data.results[parseInt(indice_lancamentos)+i].backdrop_path}" alt="Card image cap">
                        <div class="card-body">
                        <h5 class="card-title">${data.results[parseInt(indice_lancamentos)+i].title}
                        <span class="badge rounded-pill bg-dark">★  ${data.results[parseInt(indice_lancamentos)+i].vote_average}</span>
                        </h5>
                        <p class="card-text">${data.results[parseInt(indice_lancamentos)+i].release_date}</p>
                        </div>
                    </div>
                </a>
            </div>
        `;
      }
      lancamentosStr += '</div>';

      document.getElementById('itens_lancamentos').innerHTML += lancamentosStr;
      });
}


function carregarDestaques() {

    fetch('https://api.themoviedb.org/3/movie/popular?api_key=6e182b534c71d1d19a36bbc7b99e113d&language=en-US&page=1')
    .then(response => {
      return response.json();
    })
    .then(data => {
    console.log(data.results);
    carregarItemDestaque(0);
    localStorage.setItem('indice_destaque', DESTAQUES);
    });
    
}


function carregarMaisDestaques() {

    let indice_destaque = localStorage.getItem('indice_destaque');
    carregarItemDestaque(indice_destaque);
    localStorage.setItem('indice_destaque', parseInt(indice_destaque)+DESTAQUES);
}

function carregarItemDestaque(indice_destaque) {
    fetch('https://api.themoviedb.org/3/movie/popular?api_key=6e182b534c71d1d19a36bbc7b99e113d&language=en-US&page=1')
    .then(response => {
      return response.json();
    })
    .then(data => {
    console.log(data.results[indice_destaque]);
    let destaqueStr = 
    `
    <div class="row">
        <div class="col-lg-3 col-md-6 col-sm-12 col-12">
            <a href="detalhes.html?id=${data.results[indice_destaque].id}">
                <img class="banner" src="${"https://image.tmdb.org/t/p/original" + data.results[indice_destaque].poster_path}" alt="">
            </a>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-12 col-12">
            <a href="detalhes.html?id=${data.results[indice_destaque].id}">
                <h2>${data.results[indice_destaque].title}</h2>
                <p>${data.results[indice_destaque].release_date}</p>
                <p>${data.results[indice_destaque].overview.substring(0, 200)+'...'}</p>
            </a>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-12 col-12">
            <a href="detalhes.html?id=${data.results[parseInt(indice_destaque)+1].id}">
                <img class="banner" src="${"https://image.tmdb.org/t/p/original" + data.results[parseInt(indice_destaque)+1].poster_path}" alt="">
            </a>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-12 col-12">
            <a href="detalhes.html?id=${data.results[parseInt(indice_destaque)+1].id}">
                <h2>${data.results[parseInt(indice_destaque)+1].title}</h2>
                <p>${data.results[parseInt(indice_destaque)+1].release_date}</p>
                <p>${data.results[parseInt(indice_destaque)+1].overview.substring(0, 250)+'...'}</p>
            </a>
        </div>
    </div>
    `;

    document.getElementById('itens_destaque').innerHTML += destaqueStr;
    });
}


function carregarFuturos() {
    fetch('https://api.themoviedb.org/3/movie/upcoming?api_key=6e182b534c71d1d19a36bbc7b99e113d&language=en-US&page=1')
    .then(response => {
      return response.json();
    })
    .then(data => {
    console.log(data.results);
    carregarItemFuturo(0);
    localStorage.setItem('indice_futuro', FUTUROS);
    });
}


function carregarMaisFuturos() {
    let indice_futuro = localStorage.getItem('indice_futuro');
    carregarItemFuturo(indice_futuro);
    localStorage.setItem('indice_futuro', parseInt(indice_futuro)+FUTUROS);
}

function carregarItemFuturo(indice_futuro) {
    fetch('https://api.themoviedb.org/3/movie/upcoming?api_key=6e182b534c71d1d19a36bbc7b99e113d&language=en-US&page=1')
    .then(response => {
      return response.json();
    })
    .then(data => {
    console.log(data.results[indice_futuro]);
    let futuroStr = "";
    if (indice_futuro % 2 == 0 ) {
        futuroStr = 
        `
        <div class="row itens_proximos">
                <div class="col-lg-1 col-md-0 col-sm-0 col-0"></div>
                <div class="col-lg-4 col-md-12 col-sm-12 col-12">
                    <a href="detalhes.html?id=${data.results[indice_futuro].id}">
                        <h3>${data.results[indice_futuro].title}</h3>
                        <p>${data.results[indice_futuro].overview}</p>
                        <p>${data.results[indice_futuro].release_date}</p>
                    </a>
                </div>
                <div class="col-lg-1 col-md-0 col-sm-0 col-0"></div>
                <div class="col-lg-6 col-md-12 col-sm-12 col-12">
                    <a href="detalhes.html?id=${data.results[indice_futuro].id}">
                        <img src="${"https://image.tmdb.org/t/p/original" + data.results[indice_futuro].backdrop_path}" alt="">
                    </a>
                </div>
            </div>
        `;
    }
    else {
        futuroStr = 
        `
        <div class="row itens_proximos">
                <div class="col-lg-6 col-md-12 col-sm-12 col-12">
                    <a href="detalhes.html?id=${data.results[indice_futuro].id}">
                        <img src="${"https://image.tmdb.org/t/p/original" + data.results[indice_futuro].backdrop_path}" alt="">
                    </a>
                </div>
                <div class="col-lg-1 col-md-0 col-sm-0 col-0"></div>
                <div class="col-lg-4 col-md-12 col-sm-12 col-12">
                    <a href="detalhes.html?id=${data.results[indice_futuro].id}">
                        <h3>${data.results[indice_futuro].title}</h3>
                        <p>${data.results[indice_futuro].overview}</p>
                        <p>${data.results[indice_futuro].release_date}</p>
                    </a>
                </div>
                <div class="col-lg-1 col-md-0 col-sm-0 col-0"></div>
            </div>
        `;
    }

    document.getElementById('itens_futuros').innerHTML += futuroStr;
    });
}

function imagem(data) {
    if ( data.backdrop_path ) {
        return `<img src="${"https://image.tmdb.org/t/p/original" + data.backdrop_path}" alt="">`;
    }
    else {
        return '<img src="imgs/placeholder-img.jpg" alt="">';
    }

}

function pesquisar() {
    let params = new URLSearchParams(window.location.search);
    let s = params.get("s"); 
    fetch('https://api.themoviedb.org/3/search/movie?api_key=6e182b534c71d1d19a36bbc7b99e113d&language=en-US&page=1&include_adult=false&query=' + s)
    .then(response => {
        return response.json();
    })
    .then(data => {
        console.log(data);
        pesquisaStr = '<div class="row">';
        for ( let i = 0; i < data.results.length; i++ ) {
            pesquisaStr += 
        `
        <a href="detalhes.html?id=${data.results[i].id}">
            <div class="row">
                <div class="col-lg-2 col-md-4 col-sm-12 col-12">
                `

            pesquisaStr += imagem(data.results[i],);

            pesquisaStr += `
                </div>
                <div class="col-lg-10 col-md-8 col-sm-12 col-12 item_pesquisa">
                    <h3>${data.results[i].title}</h3>
                    <p>${data.results[i].release_date}</p>
                    <p>${data.results[i].overview.substring(0, 100)}...</p>
                </div>
            </div>
        </a>`
        }

        pesquisaStr += "</div>";

        document.getElementById('itens_pesquisa').innerHTML += pesquisaStr;
    })
}