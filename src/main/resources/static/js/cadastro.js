document.addEventListener("DOMContentLoaded", function () {
    const formularioCadastro = document.getElementById("formularioCadastro");

    formularioCadastro.addEventListener("submit", function (event) {
        event.preventDefault(); // Evita o comportamento padrão de envio do formulário.

        // Captura os dados do formulário.
        const nmConvidado = document.getElementById("nmConvidado").value;
        const nmEmail = document.getElementById("nmEmail").value;
        const nrTelefone = document.getElementById("nrTelefone").value;
        const txCpf = document.getElementById("txCpf").value;
        const cdSenha = document.getElementById("cdSenha").value;

        // Objeto com os dados para enviar como JSON.
        const dados = {
            nmConvidado,
            nmEmail,
            nrTelefone,
            txCpf,
            cdSenha,
        };

        fetch("/convidado/novo", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(dados),
        })
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
            })
            .catch((error) => {
                // Lidar com erros de solicitação.
                console.error("Erro na solicitação:", error);
                // Exibir uma mensagem de erro ou realizar outra ação apropriada.
            });
    });
});
