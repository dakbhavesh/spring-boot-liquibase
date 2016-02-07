# Spring Boot with Liquibase

Once you have liquibase and database dependency in place, Spring Boot will autoconfigure it and override defaults if any configuration is provided.

This application has db console available on [url] (http://localhost:8585/h2-console)
**What is liquibase?**

Liquibase is an open source database independent library for tracking, managing and applying database schema changes.

Find more details [Here] (http://www.liquibase.org/)

**Major Concepts**

* Changelog file - contains all change sets
* Change set - Identified by id and its author. Every time liquibase is run it queries DATABASECHANGELOG to find out the changelogs to be executed.
* Changes - A single unit of change to be applied in database
* Preconditions - execute change sets only if pre-conditions are met. e.g. database is oracle and user is system.
* Contexts - context are useful when you want to execute change sets per client or environment wise.

Best Practices: http://www.liquibase.org/bestpractices.html