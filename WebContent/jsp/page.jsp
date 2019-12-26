<%--
    Author     : SakuraSora 
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--分页 -->
<c:if test="${empty orderPageBean.data }">
	<h3 style="font-family: 华文行楷">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您还没有订单~_~
	</h3>
	<br>
	<br>
</c:if>
<c:if test="${not empty orderPageBean.data }">
	<div style="width: 380px; margin: 0 auto; margin-top: 50px;">
		<ul class="pagination" style="text-align: center; margin-top: 10px;">

			<!-- 判断是否是第一页 -->
			<c:if test="${orderPageBean.pageNumber == 1 }">
				<li class="disabled"><a href="javascript:void(0)"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
			</c:if>

			<!-- 不是第一页 -->
			<!-- ${param.categoryId} 从地址栏中获取 categoryId-->
			<c:if test="${orderPageBean.pageNumber != 1 }">
				<li><a
					href="${pageContext.request.contextPath}/order?method=findMyOrdersByPage&pageNumber=${orderPageBean.pageNumber-1}"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
			</c:if>

			<!-- 展示所有页码 -->
			<c:forEach begin="1" end="${orderPageBean.totalPage }" var="n">
				<!-- 判断是否是当前页 -->
				<c:if test="${orderPageBean.pageNumber == n }">
					<li class="active"><a href="javascript:void(0)">${n }</a></li>
				</c:if>
				<!-- 不是当前页 -->
				<c:if test="${orderPageBean.pageNumber != n }">
					<li><a
						href="${pageContext.request.contextPath}/order?method=findMyOrdersByPage&pageNumber=${n}">${n }</a></li>
				</c:if>
			</c:forEach>

			<!-- 判断是否是最后一页 -->
			<c:if test="${orderPageBean.pageNumber == orderPageBean.totalPage }">
				<li class="disabled"><a href="javascript:void(0)"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</c:if>

			<!-- 不是最后一页 -->
			<c:if test="${orderPageBean.pageNumber != orderPageBean.totalPage }">
				<li><a
					href="${pageContext.request.contextPath}/order?method=findMyOrdersByPage&pageNumber=${orderPageBean.pageNumber+1}"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</c:if>
		</ul>
	</div>
</c:if>
<!-- 分页结束=======================        -->