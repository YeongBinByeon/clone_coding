from django.urls import path
from . import views

urlpatterns = [
    path('', views.post_list),
    path('<int:pk>/', views.post_detail),
]
