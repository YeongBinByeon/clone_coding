from django.contrib import admin
from .models import Post
from django.utils.safestring import mark_safe

# Register your models here.
#admin.site.register(Post)

@admin.register(Post)
class PostAdmin(admin.ModelAdmin):
    list_display = ['id', 'photo_tag', 'message', 'message_length', 'is_public', 'created_at', 'updated_at']
    list_display_links = ['message']
    search_fields = ['message']
    list_filter = ['message', 'is_public']
    
    def photo_tag(self, bbbb):
        if bbbb.photo:
            ## 이미지 태그를 리턴함
            #return f'<img src = "{bbbb.photo.url}" />'
            ## 이미지를 보여줌 
            return mark_safe(f'<img src = "{bbbb.photo.url}" style="width: 72px;"/>')
        return None

    def message_length(self, kkkk):
        #return len(kkkk.message)
        return f"{len(kkkk.message)} 글자"