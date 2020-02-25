def numAtoms(x,y = 196.97):
    atoms = (x/y) * (6.022 * (10 ** 23))
    print(atoms)

numAtoms(10)
numAtoms(10,12.001)
numAtoms(10,1.008)