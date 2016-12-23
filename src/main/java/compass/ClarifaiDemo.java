package compass;

import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.input.image.ClarifaiImage;
import okhttp3.OkHttpClient;

public class ClarifaiDemo {
	
	final static ClarifaiClient client = new ClarifaiBuilder("afzMnY-M6cBApZKDJ-XxmNdftzlDdZmjgguP3LWA", "dVjNTuWzKuP52Wdx-_G2zkVrL6winIxZ2Tn0dUVr")
    .client(new OkHttpClient()) // OPTIONAL. Allows customization of OkHttp by the user
    .buildSync(); // or use .build() to get a Future<ClarifaiClient>
	
	
	public static void main(String[] args) {
		System.out.println(
		client.getDefaultModels().generalModel().predict()
	      .withInputs(
	          ClarifaiInput.forImage(ClarifaiImage.of("https://samples.clarifai.com/metro-north.jpg"))
	      )
	      .executeSync().rawBody()
				);
	}
	
}


