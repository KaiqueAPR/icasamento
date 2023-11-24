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