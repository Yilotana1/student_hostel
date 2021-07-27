<#import "parts/common.ftlh" as c/>
<#include "parts/security.ftlh"/>

<@c.basic>

    <h3 class="text-center mb-5">Профіль</h3>
    <div class="row">
        <div class="col-2 mx-5">
            <img src="/images/${authUser.photoName}" class="img-thumbnail" alt="...">

            <form action="/profile/change_photo" method="post" enctype="multipart/form-data">
                <div class="custom-file">
                    <input id="file" type="file" name="file"/>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <br/>
                <button type="submit" class="btn btn-primary">Виконати</button>
            </form>
        </div>


        <div class="col-4">
            <#include "parts/userEdit.ftlh"/>
        </div>

    </div>

</@c.basic>

