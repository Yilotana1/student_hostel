<div>
    <form action="/login" method="post">
        <div class="form-group mt-3">
            <label for="username">Логін</label>
            <input name="username" type="text" class="form-control" id="username" placeholder="Введіть логін">
        </div>
        <div class="form-group mt-3">
            <label for="password">Пароль</label>
            <input name="password" type="password" class="form-control" id="password" placeholder="Пароль">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </div>
        <input type="submit" class="btn btn-success my-3" value="Логін"/>
    </form>

</div>

