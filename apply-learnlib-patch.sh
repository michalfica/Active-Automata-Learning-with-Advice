#!/bin/bash
set -e

# Ensure submodules are up to date
git submodule update --init --recursive

# Apply the patch
echo "Applying LearnLib customizations..."
patch -p1 -d learnlib < patches/learnlib-custom.patch

echo "LearnLib has been patched successfully."

