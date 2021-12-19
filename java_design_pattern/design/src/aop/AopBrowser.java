package aop;

import proxy.Html;
import proxy.IBrowser;

public class AopBrowser implements IBrowser {
	
	private String url;
	private Html html;
	private Runnable before;
	private Runnable after;
	
	public AopBrowser(String url, Runnable before, Runnable after) {
		this.url = url;
		this.before = before;
		this.after = after;
	}

	@Override
	public Html show() {
		before.run();
		if(html == null) {
			this.html = new Html(url);
			System.out.println("BrowserProxy loading html from : " +url);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		after.run();
		System.out.println("BrowserProxy use cash html : "+url);
		return html;
	}

}
