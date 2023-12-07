const nmCidade = document.getElementById('nmCidade');
const selectSugestoes = document.getElementById('sugestoes');

nmCidade.addEventListener('input', debounce(buscarCidades, 300));

selectSugestoes.addEventListener('change', function () {
    const selectedOption = selectSugestoes.options[selectSugestoes.selectedIndex];

    if (selectedOption) {
        const selectedValue = selectedOption.value.split('-')[0];
        nmCidade.value = selectedValue;
        selectSugestoes.style.display = 'none';

        // Atualizar o valor do campo oculto cdCidade com o valor selecionado
        const selectedCdCidade = selectedOption.getAttribute('data-cdCidade');
        document.getElementById('cdCidade').value = selectedCdCidade;
        console.log("Valor do codigo da cidade: " + selectedCdCidade);
    }
});

function buscarCidades() {
    const termo = nmCidade.value.trim();

    if (termo.length === 0) {
        // Limpar o select e ocultá-lo se o campo de busca estiver vazio
        selectSugestoes.innerHTML = '';
        selectSugestoes.style.display = 'none';
        return;
    }

    const apiUrl = `/cidade/buscar-cidades?termo=${termo}`;

    fetch(apiUrl)
        .then(response => response.json())
        .then(data => exibirSugestoes(data))
        .catch(error => console.error('Erro ao buscar cidades:', error));
}

function exibirSugestoes(sugestoes) {
    // Limpar as opções existentes
    selectSugestoes.innerHTML = '';

    if (sugestoes.length === 0) {
        // Ocultar o select se não houver sugestões
        selectSugestoes.style.display = 'none';
        return;
    }

    // Adicionar sugestões ao select
    sugestoes.forEach(sugestao => {
        const option = document.createElement('option');
        option.value = `${sugestao.nmCidade}-${sugestao.sgEstado}`;
        option.text = `${sugestao.nmCidade} - ${sugestao.sgEstado}`;

        const cdCidade = sugestao.cdCidade; // Declare a variável dentro do escopo do loop

        option.setAttribute('data-cdCidade', cdCidade);

        selectSugestoes.add(option);
    });

    // Exibir o select apenas se houver sugestões
    selectSugestoes.style.display = 'block';
    // Ajustar a altura do select
    selectSugestoes.style.height = 'auto';
}
// Função de debounce para evitar múltiplas chamadas durante a digitação rápida
function debounce(funcao, delay) {
    let timeoutId;
    return function () {
        clearTimeout(timeoutId);
        timeoutId = setTimeout(() => {
            funcao.apply(this, arguments);
        }, delay);
    };
}

// Chamada que retorna uma lista com todos os estados
const apiUrl = '/estado/buscar-estados';
const selectEstado = document.getElementById('nmEstado');


// Adicionar uma opção vazia
const optionVazia = document.createElement('option');
optionVazia.value = '';
optionVazia.text = '';
selectEstado.add(optionVazia);

// Configuração da requisição
const requestOptions = {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json',
    },
};

// Enviar a solicitação Fetch
fetch(apiUrl, requestOptions)
    .then(response => {
        if (!response.ok) {
            throw new Error(`Erro na solicitação: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        // Preencher o campo de seleção com as siglas dos estados
        data.forEach(estado => {
            const option = document.createElement('option');
            option.value = estado.cdEstado;
            option.text = estado.sgEstado;
            selectEstado.add(option);
        });
    })
    .catch(error => {
        console.error('Erro na solicitação:', error.message);
        // Tratar erros, por exemplo, exibir uma mensagem de erro na tela
    });

// Evento de clique no botão de pesquisa
document.getElementById('btnPesquisar').addEventListener('click', buscarLocaisCasamento);

// Chamar buscarLocaisCasamento quando a página é carregada
document.addEventListener('DOMContentLoaded', () => {
    // Chamada inicial para carregar todos os álbuns
    buscarLocaisCasamento();
});

// Função para buscar locais de casamento
function buscarLocaisCasamento() {
    // Coletar os valores dos campos
    const dtCasamento = document.getElementById('dtCasamento').value;
    const qtdConvidados = document.getElementById('qtdConvidados').value;
    const cdCidade = document.getElementById('cdCidade').value;
    // Coletar o valor do estado
    const selectEstado = document.getElementById('nmEstado');
    const cdEstado = selectEstado.value;

    // Criar o objeto LocalCasamentoRequestDto
    const localCasamentoRequestDto = {
        dtCasamento: dtCasamento,
        qtdConvidados: qtdConvidados,
        estadoModel: {
            cdEstado: cdEstado
        },
        cidadeModel: {
            cdCidade: cdCidade
        },
    };

    // Enviar a requisição para o backend
    const apiUrl = '/local-casamento/buscar-locais-casamento';
    fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(localCasamentoRequestDto),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Erro na solicitação: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            // Preencher os álbuns com os dados retornados
            popularAlbums(data);
        })
        .catch(error => console.error('Erro ao buscar locais de casamento:', error));

    // Função para popular os álbuns com os dados
    function popularAlbums(data) {
        const containerAlbum = document.getElementById('containerAlbum');

        // Limpar os álbuns existentes
        containerAlbum.innerHTML = '';

        // Verificar se há dados retornados
        if (data && data.length > 0) {
            // Iterar sobre os dados e criar cards para cada local
            for (let i = 0; i < data.length; i += 3) {
                // Criar uma nova linha a cada três álbuns
                const row = document.createElement('div');
                row.classList.add('row');

                // Iterar sobre os próximos três álbuns ou menos se não houver mais
                for (let j = i; j < i + 3 && j < data.length; j++) {
                    const local = data[j];
                    const card = criarCard(local);
                    row.appendChild(card);
                }

                // Adicionar a linha ao contêiner dos álbuns
                containerAlbum.appendChild(row);
            }
        } else {
            // Caso não haja dados, exibir uma mensagem ou realizar outra ação apropriada
            containerAlbum.innerHTML = '<p>Nenhum local encontrado.</p>';
        }
    }

    // Função para criar um card com os dados do local
    function criarCard(local) {
        const card = document.createElement('div');
        card.classList.add('col-md-4', 'col-sm-6'); // Adicionando classes de coluna para ajustar o layout responsivo
        card.innerHTML = `
        <div class="card mb-4 shadow-sm">
            <a href="${local.txUrlRedeSocial}" target="_blank"> <!-- Adicionando o link à imagem -->
                <img src="${local.txUrlImagem}" class="card-img-top" alt="Imagem do local">
            </a>
            <div class="card-body">
                <h5 class="card-text">${local.nmLocalCasamento}</h5>
                <p class="card-text">${'Quantidade máxima de convidados: ' + local.qtdConvidados}</p>
                <p class="card-text">${'Localização: ' + local.cidadeModel.nmCidade + ', ' + local.cidadeModel.sgEstado}</p>
            </div>
        </div>
    `;
        return card;
    }

}