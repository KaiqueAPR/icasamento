/* Requisição HTTP do método GRAVAR no backend
document.getElementById("btnGravar").addEventListener("click", function () {
    fetch('/novo', {
        method: 'POST',
    })
        .then(response => response.text())
        .then(data => {
            console.log(data);
            alert(data);
        })
        .catch(error => {
            console.error('Erro:', error);
        });
});*/