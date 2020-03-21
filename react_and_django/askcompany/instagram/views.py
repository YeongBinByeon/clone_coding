from django.shortcuts import render, get_object_or_404
from django.http import HttpRequest, HttpResponse, Http404
from django.views.generic import ListView, DetailView

# Create your views here.
from .models import Post

post_list = ListView.as_view(model=Post, paginate_by=10)

# def post_list(request):
#     print(request)
#     qs = Post.objects.all()
#     q = request.GET.get('q','')
#     if q:
#         qs = qs.filter(message__icontains=q)
    
#     # instagram/templates/instagram/post_list.html
#     return render(request, 'instagram/post_list.html', {
#         'post_list':qs,
#         'q':q,
#     })

# def post_detail(request: HttpRequest, pk: int) -> HttpResponse:
#     # try:
#     #     post = Post.objects.get(pk=pk) # 앞에는 필드명, 뒤에는 파라메타로 받은 값, 존재하지 않는 pk가 들어오면 DoesNotExist 예외 발생
#     # except Post.DoesNotExist: #http response를 return 하는 것이 아니라 404 예외를 발생시키는 부분임 
#     #     raise Http404  
    
#     # 밑 코드 한줄이 위 주석한 4줄과 동일하다. 예외처리를 간편하게 적용하기 위하여 아래 처럼 사용한다. 
#     post = get_object_or_404(Post, pk=pk)

#     return render(request, 'instagram/post_detail.html', {
#         'post':post,
#     })

#post_detail = DetailView.as_view(model=Post)

### 아래 1가지와 위 2가지의 post_detail views 함수 구현 모두 동일하게 동작한다.
### 
class PostDetailView(DetailView):
    model = Post
    pk_url_kwarg = 'pk'

    def get_queryset(self):
        qs = super().get_queryset()
        #login이 되어있지 않은 경우 공개된 data만 보게 하는 부분
        if not self.request.user.is_authenticated:
            qs = qs.filter(is_public=True)
        return qs


post_detail = PostDetailView.as_view()

def archives_year(request: HttpRequest, year: int) -> HttpResponse:
    return HttpResponse(f"{year}년 archives")

