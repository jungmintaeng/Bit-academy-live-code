import re
s = """
<html>
    <body style='background-color:#ffff'>
        <h4>Click</h4>
        <a href='http://www.python.org'>Here</a>
        <p>
        	To connect to the most powerful tools in the world.
        </p>
    </body>
</html>"""
matching_str = re.findall('<.*?>', s)
for string in matching_str:
    s = s.replace(string, '')
print(s)
