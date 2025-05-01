# Import the required libraries
import torch
import transformers
from transformers import AutoTokenizer, AutoModelForCausalLM

# Load the model and tokenizer
tokenizer = AutoTokenizer.from_pretrained("fdtn-ai/Foundation-Sec-8B")
model = AutoModelForCausalLM.from_pretrained("fdtn-ai/Foundation-Sec-8B")

# Tokenize the input
inputs = tokenizer(prompt, return_tensors="pt")

# Generate the response
outputs = model.generate(
    inputs["input_ids"],
    pad_token_id=tokenizer.eos_token_id,
    attention_mask=inputs["attention_mask"],
    max_new_tokens=10,
    do_sample=True,
    temperature=0.8,
    top_p=0.9,
)

# Decode and print the response
response = tokenizer.decode(outputs[0], skip_special_tokens=True)
# Extract the generated text by slicing the output tokens
generated_tokens = outputs[0][inputs["input_ids"].size(1):]
response = tokenizer.decode(generated_tokens, skip_special_tokens=True).strip()
print(response)