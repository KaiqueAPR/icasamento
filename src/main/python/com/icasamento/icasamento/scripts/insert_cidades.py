import requests
import mysql.connector

# Conectar ao banco de dados
conexao_bd = mysql.connector.connect(
    host='localhost',
    user='root',
    password='root',
    database='icasamento'
)

# Criar cursor
cursor = conexao_bd.cursor()

# URL da API de localidades do IBGE
url_api_ibge = 'https://servicodados.ibge.gov.br/api/v1/localidades/municipios'

# Fazer solicitação à API
resposta_api = requests.get(url_api_ibge)

# Verificar se a solicitação foi bem-sucedida (código 200)
if resposta_api.status_code == 200:
    # Obter os dados da resposta em formato JSON
    dados_municipios = resposta_api.json()

    # Iterar sobre os dados e inserir na tabela do banco de dados
    for municipio in dados_municipios:
        nome_municipio = municipio['nome']
        sigla_estado = municipio['microrregiao']['mesorregiao']['UF']['sigla']

        # Executar a inserção na tabela 'cidade' usando placeholders
        query_insercao = "INSERT INTO cidade (CIDA_NM_CIDADE, CIDA_SG_SIGLA_ESTADO) VALUES (%s, %s)"
        valores = (nome_municipio, sigla_estado)

        cursor.execute(query_insercao, valores)

        # Confirmar a transação
        conexao_bd.commit()

    print("Inserção concluída com sucesso!")

# Fechar cursor e conexão com o banco de dados
cursor.close()
conexao_bd.close()
