const nmCidade = document.getElementById('nmCidade');
const selectSugestoes = document.getElementById('sugestoes');

nmCidade.addEventListener('input', debounce(buscarCidades, 300));

selectSugestoes.addEventListener('change', function () {

    nmCidade.value = selectSugestoes.value;
    // Ocultar o select após a seleção
    selectSugestoes.style.display = 'none';
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

//Chamada que retorna uma lista com todos os estados
const apiUrl = '/estado/buscar-estados';
const selectEstado = document.getElementById('nmEstado'); // Substitua 'txEstado' pelo ID real do seu campo de seleção

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

// Função para buscar locais de casamento
function buscarLocaisCasamento() {
    // Coletar os valores dos campos
    const dtCasamento = document.getElementById('dtCasamento').value;
    const qtdConvidados = document.getElementById('qtdConvidados').value;
    const cdEstado = document.getElementById('cdEstado').value;
    const cdCidade = document.getElementById('cdCidade').value;

    // Criar o objeto LocalCasamentoRequestDto
    const localCasamentoRequestDto = {
        dtCasamento: dtCasamento,
        qtdConvidados: qtdConvidados,
        estadoModel: {
            cdEstado: cdEstado
        },
        cidadeModel: {
            cdCidade: cdCidade
        }
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
            // Atualizar os dashboards no HTML com os dados retornados
            // Você precisa implementar a lógica para isso
            // Exemplo: exibirLocaisCasamentoNoDashboard(data);
        })
        .catch(error => console.error('Erro ao buscar locais de casamento:', error));
}

// Evento de clique no botão de pesquisa
document.getElementById('btnPesquisar').addEventListener('click', buscarLocaisCasamento);
