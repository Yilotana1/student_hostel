<#assign springContextExists = Session.SPRING_SECURITY_CONTEXT??/>

<#if springContextExists>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    >
</#if>