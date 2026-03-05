FROM python:3.9-slim
WORKDIR /app
COPY sensor.py .
RUN pip install requests
CMD ["python", "-u", "sensor.py"]