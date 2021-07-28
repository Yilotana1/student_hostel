<#import "parts/common.ftlh" as c/>
<#include "parts/security.ftlh"/>

<@c.basic>

    <#if authUser.role == 'ADMIN'>
        <a class="btn btn-primary" href="/notifications/create">Створити</a>
    </#if>

    <div class="row">
        <#list notifications as notification>
            <div class="col-4 card text-white bg-success my-3 mx-3" style="max-width: 25rem;">
                <div class="card-header">${notification.title}</div>
                <div class="card-body">
                    <h5 class="card-title">${notification.author.firstname} ${notification.author.lastname}</h5>
                    <p class="card-text">${notification.text}</p>

                    <#if authUser.role == 'ADMIN'>
                        <a href="/notifications/delete/${notification.id}" class="btn btn-danger">Видалити</a>
                    </#if>

                </div>
            </div>
        </#list>
    </div>
</@c.basic>

