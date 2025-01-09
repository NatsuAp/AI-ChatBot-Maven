package org.example.BackEnd;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatCompletion;
import com.openai.models.ChatCompletionCreateParams;
import com.openai.models.ChatCompletionMessageParam;
import com.openai.models.ChatCompletionUserMessageParam;
import com.openai.models.ChatModel;
import java.util.List;

public class APIClient {

    String apiKey = "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";

    OpenAIClient client = OpenAIOkHttpClient.builder()
            .apiKey(apiKey)
            .build();
 public ChatCompletion AIResponse(){
     ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
             .messages(List.of(ChatCompletionMessageParam.ofChatCompletionUserMessageParam(ChatCompletionUserMessageParam.builder()
                     .role(ChatCompletionUserMessageParam.Role.USER)
                     .content(ChatCompletionUserMessageParam.Content.ofTextContent("Tell me a joke"))
                     .build())))
             .model(ChatModel.GPT_4O_MINI)
             .build();
     ChatCompletion chatCompletion = client.chat().completions().create(params).validate();
     System.out.println(chatCompletion.toString());
     return chatCompletion;
 }

}
