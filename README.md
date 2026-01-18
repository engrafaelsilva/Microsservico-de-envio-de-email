# 📧 Email Service – Microsserviço de Envio de E-mails

## 📌 Visão Geral
O Email Service é um microsserviço backend desenvolvido em Java e Spring Boot, responsável pelo envio de e-mails transacionais através de SMTP, com persistência do status de envio e tratamento de falhas.

O projeto simula um cenário real de sistemas distribuídos, onde o envio de notificações precisa ser confiável, auditável e desacoplado das regras de negócio principais.

---

## 🎯 Problema Resolvido
Aplicações modernas frequentemente precisam enviar e-mails para:

- Confirmações
- Notificações
- Alertas de sistema
- Comunicação com usuários

Porém, falhas em serviços SMTP podem gerar:
- Perda de mensagens
- Falta de rastreabilidade
- Dificuldade de diagnóstico

Este microsserviço centraliza o envio de e-mails e registra o status de cada tentativa.

## 🧠 Arquitetura
- Arquitetura baseada em Microsserviço
- API REST para envio de e-mails
- Arquitetura em camadas (Controller, Service, Repository)
- Uso de DTOs para desacoplamento
- Persistência do estado do envio
- Fluxo de Envio
- A API recebe a requisição de envio
- Os dados são validados e persistidos
- O envio via SMTP é realizado
- O status do e-mail é atualizado (SENT ou ERROR)

## ⚙️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Mail
- Spring Data JPA
- Banco de Dados Relacional (PostgreSQL)
- SMTP (Gmail)
- OpenAPI / Swagger
- Maven

## 🔑 Funcionalidades Principais
- Envio de e-mails via API REST
- Persistência do histórico de envios
- Controle de status (SENT, ERROR)
- Tratamento de exceções no envio SMTP
- Documentação automática com Swagger

## 📊 Observabilidade
- Logs de falha no envio de e-mails
- Persistência do status para auditoria
- Retorno claro de sucesso ou erro na API
