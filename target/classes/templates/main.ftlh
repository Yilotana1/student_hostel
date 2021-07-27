<#import "parts/common.ftlh" as c/>


<style>
    * {
        color: #16cb68
    }
</style>

<@c.basic>

    <div class="container d-flex flex-column
                justify-content-center align-items-center">
        <div class="text-center">
            <h3>Ви завітали на сторінку гуртожитку №1</h3>
            <span>Розпорядок роботи: 8-00 - 20-00</span>
            <br/>
            <span>Адреса: вул. Вигадана 23, м. Київ</span>
            <br/>
            <br/>
            <br/>
            <h4 class="mb-4">Адміністрація:</h4>
            <#list admins as admin>

            <div class="card mb-3" style="max-width: 540px;">
                <div class="row g-0">
                    <div class="col-md-4">
                        <img src="/images/${admin.photoName}" class="img-fluid rounded-start w-100 h-100" alt="..."/>
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">${admin.firstname} ${admin.lastname}</h5>
                            <p class="card-text">Телефоний номер:${admin.phone}</p>
                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                        </div>
                    </div>
                </div>
            </div>
            </#list>

        </div>

    </div>

</@c.basic>
