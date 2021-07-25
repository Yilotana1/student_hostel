<#import "parts/common.ftlh" as c/>

<@c.basic>
    <div class="d-flex flex-column align-items-center">
    <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>

            <div class="alert alert-danger" role="alert">
                ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
            </div>


    </#if>
        <#include "parts/login.ftlh"/>
    </div>


</@c.basic>