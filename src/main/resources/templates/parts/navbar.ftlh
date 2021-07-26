<#include "security.ftlh"/>
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #16cb68">
    <div class="container-fluid">

        <a class="navbar-brand" href="/">Гуртожиток №1</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <#if user??>
                    <li class="nav-item">
                        <a class="nav-link" href="/profile">Профіль</a>
                    </li>
                </#if>

                <li class="nav-item">
                    <a class="nav-link" href="/">Оголошення</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Список поверхів</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Список жильців</a>
                </li>

            </ul>

            <#if !user??>
                <a class="btn btn-primary text-white" href="/login">Вхід</a>
            <#else>
                <form action="/logout" method="post">
                    <button type="submit" class="btn btn-primary">Вихід</button>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                </form>
            </#if>
        </div>
    </div>
</nav>

