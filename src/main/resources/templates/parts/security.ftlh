<#assign springContextExists = Session.SPRING_SECURITY_CONTEXT??/>

<#if springContextExists>
    <#assign
        authUser = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    >
</#if>