<#macro checkbox_form from_zero items_name count title select_list=[]>
    <div class="card mx-5" style="width: 15rem;">
        <div class="card-body">
            <h5 class="card-title">${title}</h5>

            <#if from_zero>
                <#assign start = 0>
                <#else>
                <#assign start = 1>
            </#if>

            <#list start..count as num>

                <div class="form-check mt-3">
                    <#if select_list?has_content>
                        <input class="form-check-input"
                               type="checkbox" ${select_list?seq_contains(num)?string('checked', '')}
                               name="${items_name}" value="${num}"
                               id="flexCheckDefault">
                    <#else>
                        <input class="form-check-input"
                               type="checkbox"
                               name="${items_name}" value="${num}"
                               id="flexCheckDefault">
                    </#if>


                    <label class="form-check-label text-primary" for="flexCheckDefault">
                        ${num}
                    </label>
                </div>

            </#list>
        </div>
    </div>

</#macro>
