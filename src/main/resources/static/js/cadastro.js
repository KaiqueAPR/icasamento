document.addEventListener("DOMContentLoaded", function () {
    const formularioCadastro = document.getElementById("formularioCadastro");

    formularioCadastro.addEventListener("submit", function (event) {
        event.preventDefault(); // Evita o comportamento padrão de envio do formulário.

        // Captura os dados do formulário.
        const txNome = document.getElementById("txNome").value;
        const txEmail = document.getElementById("txEmail").value;
        const nrTelefone = document.getElementById("nrTelefone").value;
        const txCpf = document.getElementById("txCpf").value;
        const cdSenha = document.getElementById("cdSenha").value;

        // Crie um objeto com os dados para enviar como JSON.
        const dados = {
            txNome,
            txEmail,
            nrTelefone,
            txCpf,
            cdSenha,
        };

        // Faça a solicitação POST usando fetch.
        fetch("/convidado/novo", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(dados),
        })
            .then((response) => response.json())
            .then((data) => {
                // Manipule a resposta do servidor, se necessário.
                console.log(data);
                // Você pode redirecionar o usuário para outra página, exibir uma mensagem de sucesso, etc.
            })
            .catch((error) => {
                // Lidar com erros de solicitação.
                console.error("Erro na solicitação:", error);
                // Exibir uma mensagem de erro ou realizar outra ação apropriada.
            });
    });
});
