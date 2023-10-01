import sys
from os.path import dirname, join
from com.chaquo.python import Python
import timeout_decorator

def ProgrammingBasicsFirst(codeAreaData):

    result = ["Hello World!"]
    codeAreaDataT = test(codeAreaData)
    if codeAreaDataT == result[0] or codeAreaDataT == result[0] + '\n':
        return "Your program passed all tests!"
    else:
        return f"Test [1]\n\nYour output:\n{codeAreaDataT}\n\nExpected: \n{result[0]}"


def ProgrammingBasicsSecond(codeAreaData):

    result = ["Hello World!"]
    codeAreaData += "\n\nprint(variableOutput())"
    codeAreaDataT = test(codeAreaData)
    if codeAreaDataT == result[0] or codeAreaDataT == result[0] + '\n':
        return "Your program passed all tests!"
    else:
        return f"Test [1]\n\nYour output:\n{codeAreaDataT}\n\nExpected: \n{result[0]}"

def ProgrammingBasicsThird(codeAreaData):

    x = [2, 35, 90, 6, 10, 100, 1000, 90, 45, 65, -200, 2150, -1, 5, 9]
    y = [5, 7, 90, 60, 2, 5, 2000, 4, 75, 15, 20, 50, 2, 50, 90000000]

    # Mūsu programma, kas aprēķinās rezultātu salīdzināšanai.
    result = [0] * 15
    for i in range(15):
        result[i] = str(x[i] + y[i])

    for i in range(15):
        codeAreaDataT = codeAreaData + f"\n\nprint(twoDigitsSum({x[i]}, {y[i]}))"
        codeAreaDataT = test(codeAreaDataT)
        if codeAreaDataT == result[i] or codeAreaDataT == result[i] + '\n':
            continue
        else:
            return f"Test [{i+1}]\n\nYour output:\n{codeAreaDataT}\n\nExpected: \n{result[i]}\n x = {x[i]}\n y = {y[i]}"
    return "Your program passed all tests!"

def IfStatementsFirst(codeAreaData):
    x = 7
    result = ["True"]
    codeAreaData += f"\n\nprint(firstComparison({x}))"
    codeAreaDataT = test(codeAreaData)
    if codeAreaDataT == result[0] or codeAreaDataT == result[0] + '\n':
        return "Your program passed all tests!"
    else:
        return f"Test [1]\n\nYour output:\n{codeAreaDataT}\n\nExpected: \n{result[0]}"

def IfStatementsSecond(codeAreaData):

    x = [99, 101, 100, 56, -3, 10, 1000, 8, 0, 54]
    result = [0] * 10
    for i in range(10):
        if x[i] > 100:
            result[i] = "x is bigger than 100"
        else:
            result[i] = "x is less or equals 100"

    for i in range(10):
        codeAreaDataT = codeAreaData + f"\n\nprint(firstIfStatement({x[i]}))"
        codeAreaDataT = test(codeAreaDataT)
        if codeAreaDataT == result[i] or codeAreaDataT == result[i] + '\n':
            continue
        else:
            return f"Test [{i+1}]\n\nYour output:\n{codeAreaDataT}\n\nExpected: \n{result[i]}"
    return "Your program passed all tests!"

def IfStatementsThird(codeAreaData):

    x = [99, 101, 100, 56, -3, 10, 1000, 8, 0, 54]
    result = [0] * 10
    for i in range(10):
        if x[i] <= 100 and x[i] >= 50:
            result[i] = "True"
        else:
            result[i] = "False"

    for i in range(10):
        codeAreaDataT = codeAreaData + f"\n\nprint(isNumberInRange({x[i]}))"
        codeAreaDataT = test(codeAreaDataT)
        if codeAreaDataT == result[i] or codeAreaDataT == result[i] + '\n':
            continue
        else:
            return f"Test [{i+1}]\n\nYour output:\n{codeAreaDataT}\n\nExpected: \n{result[i]}"
    return "Your program passed all tests!"

@timeout_decorator.timeout(5)
def test(codeAreaData):

    file_dir = str(Python.getPlatform().getApplication().getFilesDir())
    filename = join(dirname(file_dir), 'file2.txt')

    try:
        pass

        original_stdout = sys.stdout

        sys.stdout = open(filename, 'w', encoding='utf-8', errors="ignore")

        exec(codeAreaData)

        sys.stdout.close()

        sys.stdout = original_stdout

        output = open(filename, 'r').read()

    except Exception as e:

        sys.stdout = original_stdout
        output = e

    return str(output)