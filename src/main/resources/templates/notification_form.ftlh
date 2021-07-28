<#import "parts/common.ftlh" as c/>

<@c.basic>

    <form action="/notifications/create" class="w-50" method="post">

        <div class="mb-3">
            <label for="title" class="form-label">Заголовок</label>
            <input type="text" name="title" class="form-control ${(titleError??)?string('is-invalid', '')}"
                   id="title" placeholder="Заголовок"/>

            <#if titleError??>
                <div class="invalid-feedback">
                    ${titleError}
                </div>
            </#if>
        </div>


        <div class="mb-3">
            <div class="form-floating">
                <textarea name="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                          placeholder="Напишіть ваше повідомлення" id="floatingTextarea2"
                          style="height: 100px"></textarea>
                <label for="floatingTextarea2">Вміст оголошення</label>
            </div>
            
            <#if textError??>
                <div class="invalid-feedback">
                    ${textError}
                </div>
            </#if>
        </div>

        <div class="form-check">
            <input name="sendEmail" class="form-check-input" type="checkbox" value="yes" id="flexCheckDefault">
            <label class="form-check-label" for="flexCheckDefault">
                Додатково розіслати користувачам на email
            </label>
        </div>
        <br/>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary">Створити</button>

    </form>


</@c.basic>