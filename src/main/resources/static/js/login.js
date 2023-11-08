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
                if (data === true) {
                    // Redireciona para a página "home.html".
                    window.location.href = "home.html";
                } else {
                    console.error(data);

                    Swal.fire({
                        position: "center",
                        icon: "error",
                        title: "Algo deu errado...",
                        showConfirmButton: false,
                        timer: 1500,
                        onClose: () => {
                            // Reativa a rolagem da página após o SweetAlert ser fechado.
                            document.body.style.overflow = "auto";
                        },
                    });
                    
                }
            })
            .catch((error) => {
                // Lidar com erros de solicitação.
                console.error("Erro na solicitação:", error);
            });
    });
});
