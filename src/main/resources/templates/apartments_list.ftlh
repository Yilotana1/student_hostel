<#import "parts/common.ftlh" as c/>
<#import "parts/checkbox_form.ftlh" as select>

<@c.basic>
    <div class="row">
        <div class="col-7">
            <form action="/apartments/search" method="get">

                <div class="input-group mb-3">
                    <input type="text" class="form-control ${(error??)?string('is-invalid', '')}"
                           placeholder="Введите номер комнаты (например 2-13, 2 - этаж, 13 - комната)"
                           aria-label="Введите номер комнаты"
                           aria-describedby="button-addon2"
                           name="apartment_num">

                    <button class="btn btn-primary" type="submit" id="button-addon2">Найти</button>
                    <#if error??>
                        <div class="invalid-feedback">
                            ${error}
                        </div>
                    </#if>
                </div>


            </form>

            <ul class="list-group">
                <#list apartments as apartment>
                    <li class="list-group-item d-flex justify-content-between align-items-start" style="color: #16cb68">
                        <div class="ms-2 me-auto">
                            <div class="fw-bold text-primary">${apartment.floor.number}-${apartment.number}</div>
                            Староста комнаты: <a href=""
                                                 class="text-primary" style="text-decoration: none">${apartment.head.firstname} ${apartment.head.lastname}</a>
                        </div>

                        <a href="/apartment/${apartment.id}" class="text-primary mx-3" style="text-decoration: none">Детальней</a>
                        <#if apartment.students?size != 0>
                            <span class="badge bg-primary rounded-pill">${apartment.students?size}</span>
                        <#else>
                            <span class="badge bg-danger rounded-pill">${apartment.students?size}</span>
                        </#if>
                    </li>
                </#list>
            </ul>
        </div>

        <div class="col-3">
            <form action="/apartments" method="get">
                <div class="mb-3">
                    <@select.checkbox_form false "floors" floor_count "Выберите этаж" floors_select />
                </div>
                <div>
                    <@select.checkbox_form true "students" student_count "Укажите количество жильцов" students_select/>
                </div>
                <button type="submit" class="btn btn-primary mx-5 my-3">Отфильтровать</button>
                <a href="/apartments/select_all" class="btn btn-primary mx-5">Выбрать все</a>
            </form>

        </div>

    </div>


</@c.basic>
