FROM python:3.7

COPY requirements.txt /requirements.txt
COPY input2.cql /input2.cql
COPY script.py /script.py

RUN pip install -r requirements.txt

CMD ["python", "script.py"]
