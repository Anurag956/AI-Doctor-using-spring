from Bard import Chatbot
token = 'YQgX4BrJjuD2x8Lyg4rsB6L_3LkipfCJZ0hFljVQj4NbR2ODVB8NoCaTwyqMUklHOlE5ew.'

import sys

# Get the command-line argument
if len(sys.argv) > 1:
    argument = sys.argv[1]
    print("Command-line argument:", argument)
else:
    print("No command-line argument provided.")

chatbot= Chatbot(token)

def prompt_chatbot(prompt):
    response = chatbot.ask(prompt)
    return response['content']

print(prompt_chatbot(argument))

