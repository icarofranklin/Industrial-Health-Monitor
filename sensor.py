import random
import time
import json
import sys # Import necessário para manipulação de sistema
import requests # Requests para fazer chamadas HTTP
from datetime import datetime

# Configuração da simulação
ID_MAQUINA = "MAQUINA-GENERICA"
INTERVALO_LEITURA = 2  # segundos

URL_BACKEND = "http://backend:8080/api/telemetria"

# SE O UTILIZADOR PASSAR UM NOME AO RODAR O SCRIPT, USAMOS ESSE NOME
# EX: python sensor.py TORNO-01
if len(sys.argv) > 1:
    ID_MAQUINA = sys.argv[1]

def gerar_dados_sensor(id_maquina):
    """
    Gera dados simulados variando conforme o tipo de máquina. 
    """
    # Lógica simples: Se for um FORNO, a temperatura é mais alta.
    # Se for outra coisa, usa valores padrão.
    
    if "FORNO" in id_maquina.upper():
        temperatura = round(random.uniform(150.0, 200.0), 2) # Fornos trabalham mais quentes (150 a 200 graus)
        rpm = 0 # Forno não roda
        vibracao = round(random.uniform(0.0, 0.5), 2)
    else: # Máquinas rotativas padrão (Prensas, Tornos, Fresas)
        temperatura = round(random.uniform(70.0, 100.0), 2)
        rpm = random.randint(1200, 1800)
        vibracao = round(random.uniform(0.1, 2.0), 2)

    # Cria o pacote de dados
    return {
        "id_maquina": id_maquina,
        "timestamp": datetime.now().isoformat(),
        "temperatura": temperatura,
        "rpm": rpm,
        "vibracao": vibracao
    }

def main():
    print(f"--- Iniciando sensor da {ID_MAQUINA} ---")
    print(f"Enviando dados para {URL_BACKEND}")
    print("Pressione Ctrl+C para encerrar.\n")

    while True:
        try:
            dados = gerar_dados_sensor(ID_MAQUINA)

            # Post para o java!
            resposta = requests.post(URL_BACKEND, json= dados)

            print(f"Enviando: {dados['temperatura']}°C | Status da API: {resposta.status_code}")

        except requests.exceptions.ConnectionError:
            print("Erro: Não foi possível conectar ao Backend. Tentando novamente...")
        except Exception as e:
            print(f"Erro inesperado: {e}")
        
        time.sleep(INTERVALO_LEITURA) 
if __name__ == "__main__":
    main()