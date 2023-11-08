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
                if (data != true) {
                    window.location.href = "login.html";
                }
            })
            .catch((error) => {
                // Lidar com erros de solicitação.
                console.error("Erro na solicitação:", error);
                // Exibir uma mensagem de erro ou realizar outra ação apropriada.
            });
    });
});

/**function validarSenha() {
    const senha = document.getElementById("cdSenha").value;

    if (senha.length < 8 || !/[A-Z]/.test(senha) || !/[a-z]/.test(senha) || !/\d/.test(senha)) {
        document.getElementById("mensagem").textContent = "A senha não atende aos critérios de validação.";
        return false; // Impede o envio do formulário
    } else {
        document.getElementById("mensagem").textContent = "Senha válida!";
        return true; // Permite o envio do formulário
    }
}**/

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