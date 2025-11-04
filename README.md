# ⚙️ TCC - API E-commerce (Versão Refatorada com Design Patterns)

Repositório de um projeto pessoal desenvolvido no contexto do meu **Trabalho de Conclusão de Curso (TCC)** do **MBA em Engenharia de Software da USP/Esalq**.

Esta versão representa a **API REST refatorada** de um sistema de **e-commerce**, **com a aplicação de padrões de projeto (Design Patterns)**, tendo como objetivo comparar seus efeitos sobre a **qualidade do código-fonte** em relação à versão legada.

---

## 🧾 Descrição

A aplicação foi desenvolvida em **Java** com **Spring Boot**, **Maven** e **MySQL**.  
Nesta versão, foram aplicados **sete padrões de projeto do catálogo GoF (Gang of Four)**:

- Strategy  
- State  
- Command  
- Builder  
- Factory Method  
- Observer  
- Chain of Responsibility  

Esses padrões foram incorporados ao código com o propósito de melhorar aspectos como **coesão, acoplamento, manutenibilidade e extensibilidade**, sem alterar as funcionalidades da API.

Para avaliação da refatoração, foram utilizadas métricas extraídas com o **SonarQube** e o **CKJM**, considerando indicadores como:

- Complexidade ciclomática e cognitiva  
- Métricas de Chidamber & Kemerer (CK Metrics)  
- Crescimento estrutural em número de classes, métodos e linhas de código  

Os resultados demonstraram uma **relação positiva entre o uso de Design Patterns e a qualidade do código**, refletindo em uma base mais **modular, organizada e sustentável**.

---

🧪 **Principais Tecnologias e Ferramentas**
- Java 17  
- Spring Boot  
- Maven  
- MySQL  
- SonarQube  
- CKJM  

---

> 💡 *Este projeto representa a versão refatorada do sistema legado, com foco em demonstrar o impacto prático dos Design Patterns na qualidade do código-fonte.*
