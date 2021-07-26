<form action="/registration" method="post" enctype="multipart/form-data">

    <div class="mb-3">
        <label for="firstname" class="form-label">Ім'я</label>
        <input type="text" name="firstname" class="form-control" id="firstname" placeholder="Ім'я">
    </div>

    <div class="mb-3">
        <label for="lastname" class="form-label">Прізвище</label>
        <input type="text" name="lastname" class="form-control" id="lastname" placeholder="Прізвище">
    </div>

    <div class="mb-3">
        <label for="username" class="form-label">Логін</label>
        <input type="text" name="username" class="form-control" id="username" placeholder="Логін">
    </div>

    <div class="mb-3">
        <label for="password" class="form-label">Пароль</label>
        <input type="password" name="password" class="form-control" id="password" placeholder="Пароль">
    </div>

    <div class="mb-3">
        <label for="email" class="form-label">Пошта</label>
        <input type="email" name="email" class="form-control" id="email" placeholder="name@example.com">
    </div>

    <div class="mb-3">
        <label for="phone" class="form-label">Мобільний номер</label>
        <input type="text" name="phone" class="form-control" id="phone" placeholder="380......">
    </div>

    <div class="mb-3">
        <label for="formFile" class="form-label">Фотографія для профілю</label>
        <input class="form-control" type="file" id="formFile" name="file">
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}" />

    <button class="btn btn-primary" type="submit">Зареєструватись</button>

</form>

