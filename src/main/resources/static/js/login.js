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

        // Desativa a rolagem da página
        document.body.style.overflow = "hidden";

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
                if (data.retornoLogin === true) {
                    // Redireciona para a página "home.html".
                    window.location.href = "home.html";
                } else {
                    Swal.fire({
                        position: "center",
                        icon: "error",
                        title: "E-mail ou Senha estão incorretos",
                        showConfirmButton: false,
                        timer: 1500,
                    });

                }
            })
            .catch((error) => {
                // Lidar com erros de solicitação.
                console.error("Erro na solicitação:", error);
            });
    });
});
