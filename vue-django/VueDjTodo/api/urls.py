from django.urls import path
from . import views

#app_name 스페이는 api로 하였음.
app_name = 'api'
urlpatterns = [
    path('todo/list/', views.ApiTodoLV.as_view(), name = 'list'),
    path('todo/<int:pk>/delete/', views.ApiTodoDelV.as_view(), name='delete'),
]
