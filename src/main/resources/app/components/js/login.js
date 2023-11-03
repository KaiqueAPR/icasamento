function validarSenha() {
    const senha = document.getElementById("txSenha").value;

    if (senha.length < 8 || !/[A-Z]/.test(senha) || !/[a-z]/.test(senha) || !/\d/.test(senha)) {
        document.getElementById("mensagem").textContent = "A senha não atende aos critérios de validação.";
        return false; // Impede o envio do formulário
    } else {
        document.getElementById("mensagem").textContent = "Senha válida!";
        return true; // Permite o envio do formulário
    }
}
