<h1>Backend for Auto Manager App</h1>
<br>
<div>
    <p>The Auto Manager application <strong>supports the management of the car fleet</strong> by:
    <p>- control of basic deadlines of liability insurance, comprehensive car insurance and technical inspections of cars,</p>
    <p>- control of expenses related to individual vehicles,</p>
    <p>- the ability to register basic information about trips.</p>
</div>
<br>
<div>
    <p><strong>The main functionality of the application's backend is REST API.</strong></p>
    <p>As an aid, views in the Thymeleaf framework have been created.</p>
</div>
<h2>Endpoints map:</h2>
You can try app in <a href="https://auto-manager-back.herokuapp.com/">Heroku</a>
<div>
    <h3>API for connect from other app:</h3><br>
    <a th:href="@{/api/cars}">api/cars</a><br>
    <a th:href="@{/api/expenses}">api/expenses</a><br>
    <a th:href="@{/api/trips}">api/trips</a><br>
</div>
<div>
    <h3>Views in thymeleaf:</h3>
    <p>(simple statistics under each table)</p>
    <a th:href="@{/cars}">cars</a><br>
    <a th:href="@{/expenses}">expenses</a><br>
    <a th:href="@{/trips}">trips</a><br>
</div>
<div>
    <h3>Other:</h3><br>
    <a th:href="@{/swagger-ui/}">swagger UI</a><br>
    <a href="https://github.com/MarcinKaminskiPL/auto-manager-back">repo in GitHub</a><br>
</div>
<h2>Technologies used:</h2>
<br>
<div>
    <p>- Java v1.8 with Spring Framework (best for Heroku)</p>
    <p>- Maven</p>
    <p>- H2 database kept in memory (ultimately PostgreSQL)</p>
    <p>- Lombok</p>
    <p>- Swagger</p>
    <p>- Thymeleaf</p>
    <p>- Git</p>
    <p>- Heroku</p>
</div>
