# 1. Imagem base do Python
FROM python:3.9-slim
# 2. Pasta de trabalho
WORKDIR /app
# 3. Copiamos o script para dentro
COPY sensor.py .
# 4. Instalamos as dependências necessárias
RUN pip install requests
# 5. O comando para rodar o sensor
CMD ["python", "-u", "sensor.py"]