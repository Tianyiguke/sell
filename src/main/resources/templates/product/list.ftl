<!DOCTYPE html>
<html lang="zh">
<#include "../common/header.ftl">
<body>

<div id="main-wrapper">
    <#include "../common/sidebar.ftl">

    <#include "../common/topbar.ftl">

    <!-- 页面主体内容 -->
    <!-- Page wrapper  -->
    <div class="page-wrapper">

        <!-- 页面功能导航 -->
        <div class="page-breadcrumb">
            <div class="row">
                <div class="col-5 align-self-center">
                    <h4 class="page-title">商品管理</h4>
                    <div class="d-flex align-items-center"></div>
                </div>
            </div>
        </div>

        <!-- 页面主体信息 -->

        <form id="upFrom" method="post" action="${basePath}/seller/product/up?productId=" >
            <input type="hidden" name="_method" value="PUT" />
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">商品列表</h4>
                            <div class="table-responsive">
                                <table id="zero_config" class="table table-striped table-bordered">
                                    <thead>
                                    <tr>
                                        <th class="text-center">商品ID</th>
                                        <th class="text-center">商品名称</th>
                                        <th class="text-center">单价</th>
                                        <th class="text-center">库存</th>
                                        <th class="text-center">商品状态</th>
                                        <th class="text-center">类目编号</th>
                                        <th class="text-center">创建时间</th>
                                        <th class="text-center">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#list productInfoPage.content as product>
                                        <tr>
                                            <td name="productId">${product.productId}</td>
                                            <td name="productName">${product.productName}</td>
                                            <td name="productPrice">${product.productPrice}</td>
                                            <td name="productStock">${product.productStock}</td>
                                            <td name="productStatus">${product.productStatusMsg}</td>
                                            <td name="categoryType">${product.categoryType}</td>
                                            <td name="createTime">${product.createTime}</td>
                                            <td>
                                                 <#if product.productStatus == 1>
                                                <a class="btn btn-sm btn-outline-info text-center"   href="${basePath}/seller/product/UpdateStatus?productId=${product.productId}" >上架</a>
                                                 </#if >
                                                 <#if product.productStatus == 0>
                                                 <#assign Pid="${product.productId}"/>
                                                <a class="btn btn-sm btn-outline-danger text-center" href="${basePath}/seller/product/UpdateStatus?productId=${product.productId}" >下架</a>
                                                 </#if>
                                                <a class="btn btn-sm btn-outline-danger text-center" href="${basePath}/seller/product/toUpdateProduct?productId=${product.productId}" >修改</a>
                                            </td>
                                        </tr>
                                        </#list>
                                    </tbody>
                                </table>

                                <!-- 分页 -->
                                <ul class="pagination float-right">
                                        <#if productInfoPage.first>
                                        <li class="page-item disabled">
                                            <a class="page-link" href="${basePath}/seller/product/list?page=${productInfoPage.number}">
                                                上一页
                                            </a>
                                        </li>
                                        <#else>
                                        <li class="page-item">
                                            <a class="page-link" href="${basePath}/seller/product/list?page=${productInfoPage.number}" aria-label="Previous">
                                                上一页
                                            </a>
                                        </li>
                                        </#if>
                                        <#list 1..productInfoPage.totalPages as index>
                                            <#if productInfoPage.number == (index - 1)>
                                        <li class="page-item active">
                                            <a class="page-link" href="${basePath}/seller/product/list?page=${index}">${index}</a>
                                        </li>
                                            <#else>
                                        <li class="page-item">
                                            <a class="page-link" href="${basePath}/seller/product/list?page=${index}">${index}</a>
                                        </li>
                                            </#if>
                                        </#list>
                                        <#if productInfoPage.last>
                                        <li class="page-item disabled">
                                            <a class="page-link" href="${basePath}/seller/product/list?page=${productInfoPage.number+1}" aria-label="Next">
                                                下一页
                                            </a>
                                        </li>
                                        <#else>
                                        <li class="page-item">
                                            <a class="page-link" href="${basePath}/seller/product/list?page=${productInfoPage.number+2}" aria-label="Next">
                                                下一页
                                            </a>
                                        </li>
                                        </#if>
                                </ul>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
    </div>
</div>


<#include "../common/layout.ftl">

<#include "../common/js.ftl">

</body>
</html>