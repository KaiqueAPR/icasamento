document.addEventListener("DOMContentLoaded", function () {
    const formularioCadastro = document.getElementById("formularioCadastro");

    const senha = document.getElementById("cdSenha")

    senha.addEventListener("input", function (event) {
        event.preventDefault();
        validarFormulario();
    });

    formularioCadastro.addEventListener("submit", function (event) {

        event.preventDefault(); // Evita o comportamento padrão de envio do formulário.

        // Captura os dados do formulário.
        const nmConvidado = document.getElementById("nmConvidado").value;
        const nmEmail = document.getElementById("nmEmail").value;
        const nrTelefone = document.getElementById("nrTelefone").value.replace(/\D/g, '');
        const txCpf = document.getElementById("txCpf").value.replace(/\D/g, '');
        const cdSenha = document.getElementById("cdSenha").value;

        // Objeto com os dados para enviar como JSON.
        const dados = {
            nmConvidado,
            nmEmail,
            nrTelefone,
            txCpf,
            cdSenha,
        };
        if (validarFormulario()) {

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
                    if (data != null) {
                        Swal.fire({
                            position: "center",
                            icon: "success",
                            title: "Conta criada com sucesso!",
                            showConfirmButton: true,
                        }).then(() => {
                            window.location.href = "login.html";
                        });

                    } else {
                        Swal.fire({
                            position: "center",
                            icon: "error",
                            title: "Algo deu errado...",
                            showConfirmButton: false,
                            timer: 1500,
                        });
                    }
                })
                .catch((error) => {
                    // Lidar com erros de solicitação.
                    console.error("Erro na solicitação:", error);
                    // Exibir uma mensagem de erro ou realizar outra ação apropriada.
                });
        }


    });
});

function validarFormulario() {
    const senha = document.getElementById("cdSenha");
    const senhaValor = senha.value;

    if (senhaValor.length < 8 || !/[A-Z]/.test(senhaValor) || !/[a-z]/.test(senhaValor) || !/\d/.test(senhaValor)) {
        senha.setCustomValidity("A senha deve conter mais de 8 caracteres, letras minúsculas e maiúsculas.");
        return false;
    }
    senha.setCustomValidity("");
    return true;
}


function formatPhoneNumber(input) {
    // Remove todos os caracteres não numéricos do valor de entrada
    const numericInput = input.value.replace(/\D/g, '');

    // Verifica o tamanho do número de telefone para aplicar a máscara apropriada
    if (numericInput.length <= 10) {
        input.value = numericInput.replace(/(\d{2})(\d{0,4})(\d{0,4})/, '($1) $2-$3');
    } else {
        input.value = numericInput.replace(/(\d{2})(\d{0,5})(\d{0,4})/, '($1) $2-$3');
    }
}

function formatCPF(input) {
    // Remove todos os caracteres não numéricos do valor de entrada
    const numericInput = input.value.replace(/\D/g, '');

    // Aplica a máscara para o CPF
    input.value = numericInput.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');
}