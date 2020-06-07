from rest_framework import generics
from rest_framework.views import APIView
from rest_framework.decorators import api_view
from rest_framework.response import Response
from rest_framework.viewsets import ModelViewSet
from .serializers import PostSerializer
from .models import Post

# class PublicPostListAPIView(generics.ListAPIView):
#     queryset = Post.objects.filter(is_public=True)
#     serializer_class = PostSerializer

# class PublicPostListAPIView(APIView):
#     def get(self, request):
#         qs = Post.objects.filter(is_public=True)
#         serializer = PostSerializer(qs, many=True)
#         return Response(serializer.data)

# public_post_list = PublicPostListAPIView.as_view()

@api_view(['GET'])
def public_post_list(request):
    qs = Post.objects.filter(is_public=True)
    serializer = PostSerializer(qs, many=True)
    return Response(serializer.data)



class PostViewSet(ModelViewSet):
    queryset = Post.objects.all() # 2가지를 최소로 해주어야 한다. 데이터의 범위 지정 
    serializer_class = PostSerializer # Serializer class 지정
    #위 ModelViewSet이 post_list의 2개 분기, post_detail 3개 분기 logic을 위 queryset과 serializer_class 2개의 정보만으로 지원을 한다는 의미이다.

    # def dispatch(self, request, *args, **kwargs):
    #     print("request.body :", request.body) # print 비추천, logger 추천
    #     print("request.POST :", request.POST) # print 비추천, logger 추천
    #     return super().dispatch(request, *args, **kwargs)
    


# def post_list(request):
#     # 2개 분기
#     pass

# def post_detail(request, pk):
#     # request.method => 3개 분기
#     pass