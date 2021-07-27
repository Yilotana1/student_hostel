<form action="/profile/edit" method="post" enctype="multipart/form-data">

    <div class="mb-3">
        <label for="firstname" class="form-label">Ім'я</label>
        <input type="text" name="firstname" value="${authUser.firstname}"
               class="form-control ${(firstnameError??)?string('is-invalid', '')}"
               id="firstname" placeholder="Ім'я"/>

        <#if firstnameError??>
            <div class="invalid-feedback">
                ${firstnameError}
            </div>
        </#if>
    </div>


    <div class="mb-3">
        <label for="lastname" class="form-label">Прізвище</label>
        <input type="text" name="lastname" value="${authUser.lastname}"
               class="form-control ${(lastnameError??)?string('is-invalid', '')}"
               id="lastname" placeholder="Прізвище">

        <#if lastnameError??>
            <div class="invalid-feedback">
                ${lastnameError}
            </div>
        </#if>
    </div>



    <div class="mb-3">
        <label for="username" class="form-label">Логін</label>
        <input type="text" name="username" value="${authUser.username}"
               class="form-control ${(usernameError??)?string('is-invalid', '')}"
               id="username" placeholder="Логін">

        <#if usernameError??>
            <div class="invalid-feedback">
                ${usernameError}
            </div>
        </#if>
    </div>



    <div class="mb-3">
        <label for="password" class="form-label">Пароль</label>
        <input type="password" name="password" value="${authUser.password}"
               class="form-control ${(passwordError??)?string('is-invalid', '')}"
               id="password" placeholder="Пароль">

        <#if passwordError??>
            <div class="invalid-feedback">
                ${passwordError}
            </div>
        </#if>
    </div>



    <div class="mb-3">
        <label for="email" class="form-label">Пошта</label>
        <input type="email" name="email" value="${authUser.email}"
               class="form-control ${(emailError??)?string('is-invalid', '')}"
               id="email" placeholder="name@example.com">

        <#if emailError??>
            <div class="invalid-feedback">
                ${emailError}
            </div>
        </#if>

    </div>


    <div class="mb-3">
        <label for="phone" class="form-label">Мобільний номер</label>
        <input type="text" name="phone" value="${authUser.phone}"
               class="form-control ${(emailError??)?string('is-invalid', '')}"
               id="phone" placeholder="380......">

        <#if phoneError??>
            <div class="invalid-feedback">
                ${phoneError}
            </div>
        </#if>
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}" />

    <button class="btn btn-primary" type="submit">Редагувати</button>

</form>

