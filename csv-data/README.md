# csv-datas project

Projeto destinado à coleta de dados de queimadas do [site do Inpe](http://queimadas.dgi.inpe.br/queimadas/portal-static/estatisticas_estados/), todos os arquivos estão em formato `CSV`. A pasta **inpe_data**, contém os arquivo originais do site, separados por **Região**, **Estado**, **Biomas**. Os arquivos `CSV` na pasta raiz trazem os dados sumarizados, ou seja, agregados.

* bioma_sumarized.csv: Dados de queimadas dos Biomas brasileiros;
* estado_sumarized.csv:  Dados de queimadas dos estados brasileiros;
* regiao_sumarized.csv: Dados de queimadas das Regiões brasileiras;

Os arquivos sumarizados, trazem o seguinte header (cabeçalho) com os dados

| ANO | JANEIRO | FEVEREIRO | MARÇO | ABRIL | MAIO | JUNHO | JULHO | AGOSTO | SETEMBRO | OUTUBRO | NOVEMBRO | DEZEMBRO | TYPE | LAT | LONG |
|-----|---------|-----------|-------|-------|------|-------|-------|--------|----------|---------|----------|----------|------|-----|------|


* 1º Coluna: Anos desde 1998
* 2º à 13º Coluna: Meses dos Ano
* 14º Coluna: Nome do tipo. No caso de Estado, os estados brasileiros, em biomas, os biomas, e regiões as regiões.
* 15º e 16º Colunas: Latitude e Longitude, respectivamente, dos locais.

Os valores das colunas do mês, contém o valor somado dos focos de incêndio de um determinado local. Por exemplo:

| ANO  | JANEIRO | FEVEREIRO | MARÇO | ABRIL | MAIO | JUNHO | JULHO | AGOSTO | SETEMBRO | OUTUBRO | NOVEMBRO | DEZEMBRO | TYPE        | LAT    | LONG   |
|------|---------|-----------|-------|-------|------|-------|-------|--------|----------|---------|----------|----------|-------------|--------|--------|
| 2020 | 768     | 806       | 1270  | 992   | 951  | 1960  | 2429  | 10430  | 16826    | 0       | 0        | 0        | Mato Grosso | -12.64 | -55.42 |

No ano de 2020, tivemos 768 focos de incêndio, no Estado do Mato Grosso. Em Agosto, tivemos 10430 e no presente mês de Setembro, 16826 focos até o dia de hoje (17/09/2020)

Qualquer dúvida ou sugestão, não deixe de nos contatar pelo projeto, abrindo uma issue.

