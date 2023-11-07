document.addEventListener("DOMContentLoaded", function () {
    const formularioLogin = document.getElementById("formularioLogin");

    formularioLogin.addEventListener("submit", function (event) {
        event.preventDefault(); // Evita o comportamento padrão de envio do formulário.

        // Captura os dados do formulário.
        const nmEmail = document.getElementById("nmEmail").value;
        const cdSenha = document.getElementById("cdSenha").value;

        // Objeto com os dados para enviar como JSON.
        const dados = {
            nmEmail,
            cdSenha,
        };

        fetch("/login/entrar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(dados),
        })
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                if (data === true) {
                    // Redireciona para a página "home.html".
                    window.location.href = "home.html";
                } else {
                    console.log("E-mail ou Senha errados.");
                }
            })
            .catch((error) => {
                // Lidar com erros de solicitação.
                console.error("Erro na solicitação:", error);
                // Exibir uma mensagem de erro ou realizar outra ação apropriada.
            });
    });
});

